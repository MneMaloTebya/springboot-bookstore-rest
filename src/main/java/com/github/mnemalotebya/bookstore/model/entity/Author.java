package com.github.mnemalotebya.bookstore.model.entity;

import com.github.mnemalotebya.bookstore.model.Stile;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String country;

    @Column(name = "stile", length = 25)
    @Enumerated(EnumType.STRING)
    private Stile stile;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}
