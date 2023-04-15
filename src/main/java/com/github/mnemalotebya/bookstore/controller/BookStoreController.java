package com.github.mnemalotebya.bookstore.controller;

import com.github.mnemalotebya.bookstore.model.entity.Author;
import com.github.mnemalotebya.bookstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookStoreController {

    private final StoreService storeService;

    @Autowired
    public BookStoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return storeService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author findAuthorById(@PathVariable int id) {
        return storeService.findAuthorById(id);
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author) {
        return storeService.saveAuthor(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable("id") int id, @RequestBody Author author) {
        return storeService.updateAuthor(id, author);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById(@PathVariable("id") int id) {
        storeService.deleteAuthorById(id);
    }

    @DeleteMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllAuthors() {
        storeService.deleteAllAuthors();
    }
}
