package com.springboot.service.interfaces;

import com.springboot.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author Rashmi.CM
 * @since 21-02-2021
 */

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book bookDetails);

    Book update(Long id, Book bookDetails);

    Book delete(Long id);
}
