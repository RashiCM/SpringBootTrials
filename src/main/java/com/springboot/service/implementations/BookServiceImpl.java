package com.springboot.service.implementations;

import com.springboot.model.Book;
import com.springboot.repository.interfaces.BookRepository;
import com.springboot.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Rashmi.CM
 * @since 21-02-2021
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        books.forEach(book -> book.setBookStatus(""));
        return books;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.of(bookRepository.findById(id).orElse(new Book(id, "", "", "","Incorrect Id:Book not found")));
    }

    @Override
    public Book save(Book bookDetails) {
        return bookRepository.save(bookDetails);
    }

    @Override
    public Book update(Long id, Book updateDetails) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            Book bookDetails = book.get();
            bookDetails.setAuthorName(updateDetails.getAuthorName());
            bookDetails.setBookName(updateDetails.getBookName());
            bookDetails.setIsbn(updateDetails.getIsbn());
            bookDetails.setBookStatus(updateDetails.getBookName() + " ," + updateDetails.getIsbn() + " :Book details updated");
            return bookRepository.save(bookDetails);
        }
        else{
            updateDetails.setBookStatus("Unable to update BookDetails due to incorrect BookId");
            updateDetails.setId(id);
            return updateDetails;
        }
    }

    @Override
    public Book delete(Long id) {
        Optional<Book> book=bookRepository.findById(id);
        if(book.isPresent()) {
            Book bookDetails = book.get();
            bookDetails.setBookStatus("Deleted Book with Id:" + bookDetails.getId() + " Name:" +  bookDetails.getBookName());
            bookRepository.delete(bookDetails);
            return bookDetails;
        }
        return new Book(-1l, "", "", "","Incorrect Id input");
    }
}
