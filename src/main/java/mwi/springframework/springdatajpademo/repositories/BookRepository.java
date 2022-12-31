package mwi.springframework.springdatajpademo.repositories;

import mwi.springframework.springdatajpademo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
