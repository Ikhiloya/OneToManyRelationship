package com.loya.onetomanybidirectionaldemo.service;

import com.loya.onetomanybidirectionaldemo.dao.AuthorDao;
import com.loya.onetomanybidirectionaldemo.entity.Author;
import com.loya.onetomanybidirectionaldemo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorDao authorDao;

    public List<Author> getAuthors() {
        return authorDao.findAll();
    }


    public Optional<Author> getAuthorById(Long authorId) {
        if (!authorDao.existsById(authorId)) {
            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
        }
        return authorDao.findById(authorId);
    }


    public Author createAuthor(Author author) {
        return authorDao.save(author);

    }

    public Author updateAuthorById(Long authorId, Author authorRequest) {
        if (!authorDao.existsById(authorId)) {
            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
        }
        Optional<Author> author = authorDao.findById(authorId);

        if (!author.isPresent()) {
            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
        }

        Author author1 = author.get();
        author1.setFirstName(authorRequest.getFirstName());
        author1.setLastName(authorRequest.getLastName());
        return authorDao.save(author1);

    }

    public ResponseEntity<Object> deleteAuthorById(long authorId) {
        if (!authorDao.existsById(authorId)) {
            throw new ResourceNotFoundException("Author with id " + authorId + " not found");
        }

        authorDao.deleteById(authorId);

        return ResponseEntity.ok().build();

    }


}
