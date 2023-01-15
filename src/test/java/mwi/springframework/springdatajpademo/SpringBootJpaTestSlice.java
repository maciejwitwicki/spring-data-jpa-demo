package mwi.springframework.springdatajpademo;

import mwi.springframework.springdatajpademo.bootstrap.DataInitializer;
import mwi.springframework.springdatajpademo.domain.Book;
import mwi.springframework.springdatajpademo.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackageClasses = DataInitializer.class)
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Test
    @Commit
    @Order(1)
    void testJpaTestSplice() {
        var countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("My Book", "12333", "Self"));

        var countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Test
    @Order(2)
    void testJpaTestSpliceTransaction() {
        var countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);

    }
}
