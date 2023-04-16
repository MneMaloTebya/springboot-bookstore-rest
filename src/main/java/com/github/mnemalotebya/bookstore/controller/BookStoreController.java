package com.github.mnemalotebya.bookstore.controller;

import com.github.mnemalotebya.bookstore.dto.AuthorDto;
import com.github.mnemalotebya.bookstore.dto.DtoMapper;
import com.github.mnemalotebya.bookstore.model.entity.Author;
import com.github.mnemalotebya.bookstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = storeService.getAllAuthors();
        if (authors.isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
        return ResponseEntity.ok().body(authors);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable int id) {
        Author author = storeService.findAuthorById(id);
        if (author == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(storeService.findAuthorById(id));
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Author> saveAuthor(@RequestBody AuthorDto dto) {
        return ResponseEntity.ok().body(storeService.saveAuthor(DtoMapper.AuthorDtoToEntity(dto)));
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") int id, @RequestBody AuthorDto dto) {
        Author author = storeService.findAuthorById(id);
        if (author == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(storeService.updateAuthor(id, DtoMapper.AuthorDtoToEntity(dto)));
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Author> deleteAuthorById(@PathVariable("id") int id) {
        Author author = storeService.findAuthorById(id);
        if (author == null) {
            return ResponseEntity.badRequest().body(null);
        }
        storeService.deleteAuthorById(id);
        return ResponseEntity.ok().body(author);
    }

    @DeleteMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteAllAuthors() {
        storeService.deleteAllAuthors();
        return ResponseEntity.ok().body("All authors was deleted");
    }
}
