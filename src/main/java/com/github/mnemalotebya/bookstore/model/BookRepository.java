package com.github.mnemalotebya.bookstore.model;

import com.github.mnemalotebya.bookstore.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
