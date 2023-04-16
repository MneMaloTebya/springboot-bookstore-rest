package com.github.mnemalotebya.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mnemalotebya.bookstore.model.entity.Author;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    @JsonProperty("id")
    @NotNull
    private int id;

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("publication")
    @NotNull
    private String publication;

    @JsonProperty("price")
    @NotNull
    private int price;

    @JsonProperty("genre")
    @NotNull
    private Genre genre;

    @JsonProperty("author")
    private Author author;
}
