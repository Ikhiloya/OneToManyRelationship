package com.loya.onetomanybidirectionaldemo.service;

import com.loya.onetomanybidirectionaldemo.dao.AuthorDao;
import com.loya.onetomanybidirectionaldemo.dao.BookDao;
import com.loya.onetomanybidirectionaldemo.entity.Author;
import com.loya.onetomanybidirectionaldemo.entity.Book;
import com.loya.onetomanybidirectionaldemo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {



    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }


    public Optional<Book> getBookById(Long bookId) {
        if (!bookDao.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }
        return bookDao.findById(bookId);
    }


    public Book createBook(Long authorId, Book book) {
        Set<Book> books = new HashSet<>();
        Author author1 = new Author();

        Optional<Author> byId = authorDao.findById(authorId);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
        }
        Author author = byId.get();

        //tie Author to Book
        book.setAuthor(author);

        Book book1 = bookDao.save(book);
        //tie Book to Author
        books.add(book1);
        author1.setBooks(books);

        return book1;

    }

    public Book updateBookById(Long bookId, Book bookRequest) {
        if (!bookDao.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }
        Optional<Book> book = bookDao.findById(bookId);

        if (!book.isPresent()) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }

        Book book1 = book.get();
        book1.setGenre(bookRequest.getGenre());
        book1.setTitle(bookRequest.getTitle());

        return bookDao.save(book1);
    }

    public ResponseEntity<Object> deleteBookById(long bookId) {
        if (!bookDao.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }

        bookDao.deleteById(bookId);

        return ResponseEntity.ok().build();

    }
}
