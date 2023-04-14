package com.github.mnemalotebya.bookstore.service;

import com.github.mnemalotebya.bookstore.dto.AuthorDto;
import com.github.mnemalotebya.bookstore.model.entity.Author;
import java.util.List;

public interface AuthorService {
    Author save(AuthorDto dto);
    void deleteById(int id);
    Author update(AuthorDto dto);
    List<Author> getAll();
    void deleteAll();
    Author getAuthorById(int id);
}
