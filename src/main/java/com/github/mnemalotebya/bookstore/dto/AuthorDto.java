package com.github.mnemalotebya.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mnemalotebya.bookstore.model.Stile;
import com.github.mnemalotebya.bookstore.model.entity.Book;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@Data
public class AuthorDto {

    @JsonProperty("id")
    @NotNull
    private int id;

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("birth")
    @NotNull
    private String birth;

    @JsonProperty("country")
    @NotNull
    private String country;

    @JsonProperty("stile")
    @NotNull
    private Stile stile;

    @JsonProperty("books")
    @NotNull
    private List<Book> books;
}
