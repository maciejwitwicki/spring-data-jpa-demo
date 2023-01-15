package mwi.springframework.springdatajpademo;

import mwi.springframework.springdatajpademo.bootstrap.DataInitializer;
import mwi.springframework.springdatajpademo.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = NONE)
@ComponentScan(basePackageClasses = DataInitializer.class)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testMySQL() {
        var countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

    }
}
