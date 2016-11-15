package practica2.modelo;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;

public class BDUsuarioTest {

    private EmbeddedDatabase db;
    BDUsuario userDao;

    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();

        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.DERBY)
                .addScript("create-table.sql")
                .addScript("insert-data.sql")
                .build();
    }

    @Test
    public void testFindByname() {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        userDao = new BDUsuario();


        List<Usuario> users = userDao.getTodosLosUsuarios();

        Assert.assertNotNull(users);
//        Assert.assertEquals(1, users.get().getId().intValue());
  //      Assert.assertEquals("mkyong", user.getName());
    //    Assert.assertEquals("mkyong@gmail.com", user.getEmail());

    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}