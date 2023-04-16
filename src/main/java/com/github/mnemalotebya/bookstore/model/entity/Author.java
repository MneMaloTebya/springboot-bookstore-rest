package com.github.mnemalotebya.bookstore.model.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    public void setBooks(List<Book> books) {
        if (this.books == null) {
            this.books = books;
        } else {
            this.books.retainAll(books);
            this.books.addAll(books);
        }
    }

    public List<Book> getBooks() {
        if (books == null) books = new ArrayList<>();
        return books;
    }
}
