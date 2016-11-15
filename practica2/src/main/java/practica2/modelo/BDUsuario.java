package practica2.modelo;

import org.eclipse.persistence.internal.jpa.querydef.CriteriaBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Mike on 09/11/2016.
 */
@Repository
public class BDUsuario {

    @Autowired
    private
    EntityManager entityManager;


    public List<Usuario> getTodosLosUsuarios() {
        String sql = "SELECT u FROM Usuario u";
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

    public boolean addUser(String nombre, String apellido, String email) {
        Usuario usuario = new Usuario(nombre, apellido, email);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Usuario findByEmail(String email) {
        String findByEmailQuery = "Select u from Usuario as u where u.email = :email";

        Query query = entityManager.createQuery(findByEmailQuery);
        query.setParameter("email", email);
        List<Usuario> result = (List<Usuario>) query.getResultList();
        if (result.size() == 1) {
            return result.get(0);
        }
        return null;
    }

    public boolean remove(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
