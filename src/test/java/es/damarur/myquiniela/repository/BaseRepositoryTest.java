package es.damarur.myquiniela.repository;

import es.damarur.myquiniela.config.RepositoryConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

@DataJpaTest
@ContextConfiguration(
        locations = "classpath:repositories.xml",
        classes = {
                RepositoryConfiguration.class
        }
)
@ImportAutoConfiguration(FlywayAutoConfiguration.class)
@ActiveProfiles("test")
public class BaseRepositoryTest {

    @Autowired
    protected TestEntityManager entityManager;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected DataSource dataSource;

}
