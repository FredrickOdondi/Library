package com.Library.Library.repository;

import com.Library.Library.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BooksRepository extends JpaRepository<Books, String> {

    // Custom query methods (optional)

    // Find books by name


    // Find books by author
    List<Books> findByBookAuthor(String bookAuthor);

    // Find books by category
    List<Books> findByCategory(String category);

    // Find books by publisher
    List<Books> findByPublisher(String publisher);

    List<Books> findByBookName(String bookName);
}
