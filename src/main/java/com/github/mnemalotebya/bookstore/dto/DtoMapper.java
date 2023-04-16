package com.github.mnemalotebya.bookstore.dto;

import com.github.mnemalotebya.bookstore.model.entity.Author;
import com.github.mnemalotebya.bookstore.model.entity.Book;

public class DtoMapper {

    public static Author AuthorDtoToEntity(AuthorDto dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setBooks(dto.getBooks());
        return author;
    }

    public static Book BookDtoToEntity(BookDto dto) {
        Book book = new Book();
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        return book;
    }
}
