package com.springBoot.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rashmi.CM
 * @since 20-02-2021
 */
@Entity
@Table(name="Books")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String book_name;
    @Column
    private String author_name;
    @Column
    private String isbn;

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Transient
    private String bookStatus;

    public Book() {
    }

    public Book(Long id, String book_name, String author_name, String isbn, String bookStatus) {
        this.id = id;
        this.book_name = book_name;
        this.author_name = author_name;
        this.isbn = isbn;
        this.bookStatus = bookStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id.equals(book.id) &&
                book_name.equals(book.book_name) &&
                author_name.equals(book.author_name) &&
                isbn.equals(book.isbn);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
