package com.Library.Library.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;  // Assuming bookId is the primary key

@Entity
@Table(name = "Books")
public class Books {

    @Id  // Indicates this field is the primary key
    private String bookId;
    private String bookName;
    private String bookAuthor;
    private String publisher;
    private String category;  // Changed from 'Category' to 'category'

    // Default constructor required by JPA
    public Books() {
    }

    // Deserialization constructor
    @JsonCreator
    public Books(
            @JsonProperty("bookId") String bookId,
            @JsonProperty("bookName") String bookName,
            @JsonProperty("bookAuthor") String bookAuthor,
            @JsonProperty("publisher") String publisher,
            @JsonProperty("category") String category) {  // Changed from 'Category' to 'category'
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.publisher = publisher;
        this.category = category;
    }

    // Getter and Setter methods
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}