package com.github.mnemalotebya.bookstore.service;

import com.github.mnemalotebya.bookstore.model.AuthorRepository;
import com.github.mnemalotebya.bookstore.model.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final AuthorRepository authorRepository;

    @Autowired
    public StoreServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author saveAuthor(Author author) {
        author.getBooks().forEach(b -> b.setAuthor(author));
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(int id, Author author) {
        authorRepository.delete(authorRepository.findById(id));
        return authorRepository.save(saveAuthor(author));
    }

    @Override
    public Author deleteAuthorById(int id) {
        Author author = findAuthorById(id);
        if (author != null) authorRepository.deleteById(id);
        return null;
    }

    @Override
    public void deleteAllAuthors() {
        authorRepository.deleteAll();
    }
}
