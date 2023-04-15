package com.github.mnemalotebya.bookstore.model;

import com.github.mnemalotebya.bookstore.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findById(int id);
    String deleteById(int id);
}
