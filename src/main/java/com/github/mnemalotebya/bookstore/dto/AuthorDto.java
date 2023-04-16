package com.github.mnemalotebya.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mnemalotebya.bookstore.model.entity.Book;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {

    @JsonProperty("id")
    @NotNull
    private int id;

    @NotNull
    @JsonProperty("name")
    private String name;

    @JsonProperty("birth")
    @NotNull
    private String birth;

    @JsonProperty("stile")
    @NotNull
    private Stile stile;

    @JsonProperty("country")
    private String country;

    @JsonProperty("books")
    @NonNull
    private List<Book> books;
}
