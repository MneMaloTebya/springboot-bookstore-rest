package com.github.mnemalotebya.bookstore.dto;

import com.github.mnemalotebya.bookstore.model.entity.Author;

public class AuthorMapping {

    public static Author toEntity(AuthorDto dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setBirth(dto.getBirth());
        author.setCountry(dto.getCountry());
        author.setStile(dto.getStile());
        author.setBooks(dto.getBooks());
        return author;
    }
}
