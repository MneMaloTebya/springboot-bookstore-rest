package com.github.mnemalotebya.bookstore.service;

import com.github.mnemalotebya.bookstore.model.entity.Author;
import java.util.List;


public interface StoreService {
    List<Author> getAllAuthors();
    Author findAuthorById(int id);
    Author saveAuthor(Author author);
    Author updateAuthor(int id, Author author);
    void deleteAuthorById(int id);
    void deleteAllAuthors();
}
