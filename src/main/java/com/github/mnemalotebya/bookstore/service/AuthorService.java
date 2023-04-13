package com.github.mnemalotebya.bookstore.service;

import com.github.mnemalotebya.bookstore.model.entity.Author;
import java.util.List;

public interface AuthorService {
    Author add(Author author);
    void deleteById(int id);
    Author update(Author author);
    List<Author> getAll();
    void deleteAll();
}
