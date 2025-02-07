package com.Library.Library.controller;

import com.Library.Library.model.Books;
import com.Library.Library.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    //  method to get all books
    @GetMapping
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    // method to add a new book
    @PostMapping
    public Books addBook(@RequestBody Books books) {
        return booksService.saveBook(books);
    }

    // Get book by name
    @GetMapping("/name/{bookName}")
    public List<Books>getBooksByNames(@PathVariable String bookName){
        return booksService.getBookByName(bookName);
    }
    // Get book by author
    @GetMapping("/author/{bookAuthor}")
    public List<Books>getBooksByAuthor(@PathVariable String bookAuthor){
        return booksService.getBookByBookAuthor(bookAuthor);
    }
    // Get book by category
    @GetMapping("/category/{category}")
    public List<Books>getBooksByCategory(@PathVariable String category){
        return booksService.getBookByCategory(category);
    }
    // Get book by publisher
    @GetMapping("/publisher/{publisher}")
    public List<Books>getBooksByPublisher(@PathVariable String publisher){
        return booksService.getBookByPublisher(publisher);
    }
    // update a book by ID
    @PutMapping("/{id}")
    public Books updateBook(@PathVariable String bookId, @RequestBody Books updatedBookDetails) {
        return booksService.updateBook(bookId, updatedBookDetails);
    }
    // Delete a book by ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String bookId) {
        booksService.deleteBook(bookId);
    }






}