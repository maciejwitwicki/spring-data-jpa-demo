package mwi.springframework.springdatajpademo.bootstrap;

import mwi.springframework.springdatajpademo.domain.Book;
import mwi.springframework.springdatajpademo.repositories.BookRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"local", "default"})
public class DataInitializer implements ApplicationRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", null);

        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring in Action", "234234", "Oreily", null);
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book id: " + book.getId());
            System.out.println("Book title : " + book.getTitle());
        });
    }
}
