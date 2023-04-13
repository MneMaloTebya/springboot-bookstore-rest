package com.github.mnemalotebya.bookstore.model.repository;

import com.github.mnemalotebya.bookstore.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    void deleteById(int id);
    Author getAuthorById(int id);
}
