package com.github.mnemalotebya.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mnemalotebya.bookstore.model.entity.Book;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class AuthorDto {

    @JsonProperty("id")
    @NotNull
    private int id;

    @JsonProperty("name")
    @NonNull
    private String name;

    @JsonProperty("books")
    @NonNull
    private List<Book> books;
}
