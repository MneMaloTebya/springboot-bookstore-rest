package com.github.mnemalotebya.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mnemalotebya.bookstore.model.entity.Author;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class BookDto {

    @JsonProperty("id")
    @NotNull
    private int id;

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("author")
    @NotNull
    private Author author;
}
