package practica2.comunication.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;

@Profile("derby")
@Configuration
public class DerbyDataSource {

    //jdbc:derby:memory:testdb
    @Bean
    public DataSource dataSource() throws SQLException {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.DERBY)
                .build();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("testDb");
        EntityManager em = factory.createEntityManager();
        return db;
    }

}