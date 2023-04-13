package com.github.mnemalotebya.bookstore.model.entity;

import com.github.mnemalotebya.bookstore.model.Genre;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_of_publication", nullable = false)
    private int dateOfPublication;

    @Column(nullable = false)
    private int price;

    @Column(columnDefinition = "ENUM('Poems', 'Detective', 'Drama', 'Thriller', 'Horror', 'For_Children')", nullable = false)
    private Genre genre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;
}
