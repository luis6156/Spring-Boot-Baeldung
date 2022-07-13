package com.baeldung.library.persistence.repo;

import com.baeldung.library.persistence.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String Title);
}
