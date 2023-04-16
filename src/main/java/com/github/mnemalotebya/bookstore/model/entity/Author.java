package com.github.mnemalotebya.bookstore.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.mnemalotebya.bookstore.dto.Stile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    @JsonIgnore
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @Column(name = "stile", length = 25)
    @Enumerated(EnumType.STRING)
    private Stile stile;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;
}
