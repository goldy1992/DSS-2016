package practica2.comunication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import practica2.modelo.BDUsuario;
import practica2.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

@ComponentScan({ "comunication", "modelo" })
@Configuration
public class SpringRootConfig {

    public static final String PERSISTENCE_UNIT_NAME = "usuario";

    @Autowired
    DataSource dataSource;


    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Bean
    public BDUsuario getBdUsuario() {
        BDUsuario bdUsuario = new BDUsuario();
        return bdUsuario;
    }

    @Bean
    EntityManager entityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Usuario yo = new Usuario("Michael", "Goldsmith", "goldy13_1992@hotmail.co.uk");
        try {
            em.getTransaction().begin();
            em.persist(yo);
            em.getTransaction().commit();
        } catch (Exception e) {

            e.printStackTrace();
        }finally {

        }
        return  em;
    }

}