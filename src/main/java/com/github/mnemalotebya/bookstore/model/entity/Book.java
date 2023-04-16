package com.github.mnemalotebya.bookstore.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.mnemalotebya.bookstore.dto.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "publication", nullable = false)
    private String publication;

    @Column(nullable = false)
    private int price;

    @Column(name = "genre", length = 25)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;

}
