package com.springboot.controller;

import com.springboot.model.Book;
import com.springboot.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    BookService bookService;

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks()
    {
        return bookService.findAll();
    }

    @GetMapping("/getBookById/{id}")
    public Optional<Book> getBookById(@PathVariable(value="id") Long id)
    {
        return bookService.findById(id);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody @Valid Book book)
    {
        book.setBookStatus("Book Saved");
        return bookService.save(book);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable(value="id") Long id, @RequestBody Book bookDetails)
    {
        return bookService.update(id, bookDetails);

    }

    @DeleteMapping("/deleteBook/{id}")
    public Book deleteBook(@PathVariable(value="id") Long id)
    {
        return bookService.delete(id);
    }
    
}
