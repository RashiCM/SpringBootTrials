package com.springBoot.Controller;

import com.springBoot.Repository.BookRepository;
import com.springBoot.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Rashmi.CM
 * @since 30-12-2020
 */
@RestController
public class BookController {

    @GetMapping("/")
    public String homePage(){
        return "Landing Page";
    }

    @GetMapping("/check1")
    public String checkPage(){
        return "Landing Page of checkPage";
    }

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/getBookById/{id}")
    public Optional<Book> getBookById(@PathVariable(value="id") Long id)
    {
        return Optional.of(bookRepository.findById(id).orElse(new Book(id, "", "", "","Incorrect Id:Book not found")));
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book)
    {
        book.setBookStatus("Book Saved");
        return bookRepository.save(book);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable(value="id") Long id, @RequestBody Book bookDetails)
    {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            Book book_new = book.get();
            book_new.setAuthor_name(bookDetails.getAuthor_name());
            book_new.setBook_name(bookDetails.getBook_name());
            book_new.setIsbn(bookDetails.getIsbn());
            book_new.setBookStatus(bookDetails.getBook_name() + " ," + bookDetails.getIsbn() + " :Book details updated");
            return bookRepository.save(book_new);
        }
        else{
            bookDetails.setBookStatus("Unable to update BookDetails due to incorrect BookId");
            bookDetails.setId(id);
            return bookDetails;
        }
    }

    @DeleteMapping("/deleteBook/{id}")
    public Book deleteBook(@PathVariable(value="id") Long id)
    {
        Optional<Book> book=bookRepository.findById(id);
        if(book.isPresent()) {
            Book bookDetails = book.get();
            bookDetails.setBookStatus("Deleted Book with Id:" + id + " Name:" +  bookDetails.getBook_name());
            bookRepository.delete(bookDetails);
            return bookDetails;
        }
        return new Book(new Long(-1), "", "", "","Incorrect Id input");
    }

    public String xyz(){
        return "xyz method()";
    }
}
