package com.springboot.model;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String bookName;
    @Column
    @NotEmpty
    private String authorName;
    @Column
    @NotEmpty
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

    public Book(Long id, String bookName, String authorName, String isbn, String bookStatus) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.isbn = isbn;
        this.bookStatus = bookStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id.equals(book.id) &&
                bookName.equals(book.bookName) &&
                authorName.equals(book.authorName) &&
                isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, authorName, isbn, bookStatus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
