package com.Library.Library.service;

import com.Library.Library.model.Books;
import com.Library.Library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BooksService {
    @Autowired
    private BooksRepository booksRepository;
    // Save a new book to the database
    public Books saveBook(Books books){
        return booksRepository.save(books);
    }
    // Get all books
    public List<Books>getAllBooks(){
        return booksRepository.findAll();
    }
    // Get books by name
    public List<Books>getBookByName(String bookName){
        if (bookName == null || bookName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
            return booksRepository.findByBookName(bookName);
    }
    // Get books by author
    public List<Books>getBookByBookAuthor(String bookAuthor){
        if (bookAuthor == null || bookAuthor.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }

        return booksRepository.findByBookAuthor(bookAuthor);
    }

    // Get books by publisher
    public List<Books>getBookByPublisher(String publisher){
        if (publisher == null || publisher.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        return booksRepository.findByPublisher(publisher);
    }

    // Method to update a book
    public Books updateBook(String bookId, Books updatedBookDetails) {
        // Check if the book with the given ID exists
        return booksRepository.findById(bookId)
                .map(books -> {
                    // Update the fields of the existing book with the new details
                    if (updatedBookDetails.getBookName() != null) {
                        books.setBookName(updatedBookDetails.getBookName());
                    }
                    if (updatedBookDetails.getBookAuthor() != null) {
                        books.setBookAuthor(updatedBookDetails.getBookAuthor());
                    }
                    if (updatedBookDetails.getCategory() != null) {
                        books.setCategory(updatedBookDetails.getCategory());
                    }
                    if (updatedBookDetails.getPublisher() != null) {
                        books.setPublisher(updatedBookDetails.getPublisher());
                    }
                    // Save the updated book
                    return booksRepository.save(books);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));
    }
    // Delete the book by bookId
    public void deleteBook(String bookId){
        // Let us first check whether the given bookId exists
        if (!booksRepository.existsById(bookId)){
            throw new RuntimeException("Book not found with ID: " + bookId);
        }
        // else just delete
        booksRepository.deleteById(bookId);
    }
    //  Get books by category
    public List<Books> getBookByCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        return booksRepository.findByCategory(category);
    }
}
