package com.github.mnemalotebya.bookstore.controller;

import com.github.mnemalotebya.bookstore.dto.AuthorDto;
import com.github.mnemalotebya.bookstore.dto.AuthorMapping;
import com.github.mnemalotebya.bookstore.model.entity.Author;
import com.github.mnemalotebya.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookStoreController {

    private final AuthorService authorService;

    @Autowired
    public BookStoreController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(value = "/authors")
    public Author add(@RequestBody AuthorDto dto) {
        return authorService.add(AuthorMapping.toEntity(dto));
    }

    @GetMapping("/authors")
    public List<Author> getAll() {
        Iterable<Author> iterable = authorService.getAll();
        List<Author> authors = new ArrayList<>();
        iterable.forEach(authors::add);
        return authors;
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthorById(@PathVariable int id) {
        authorService.deleteById(id);
        return "The author with id: " + id + " has been deleted";
    }

    @PutMapping("/authors")
    public Author update(@RequestBody Author author) {
        return authorService.update(author);
    }

    @DeleteMapping("/authors")
    public String deleteAllAuthors() {
        authorService.deleteAll();
        return "All authors was deleted";
    }
}
