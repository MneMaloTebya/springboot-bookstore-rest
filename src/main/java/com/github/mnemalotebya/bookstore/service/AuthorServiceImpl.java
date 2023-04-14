package com.github.mnemalotebya.bookstore.service;

import com.github.mnemalotebya.bookstore.dto.AuthorDto;
import com.github.mnemalotebya.bookstore.dto.AuthorMapping;
import com.github.mnemalotebya.bookstore.model.entity.Author;
import com.github.mnemalotebya.bookstore.model.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(AuthorDto dto) {
        return authorRepository.save(AuthorMapping.toNewEntity(dto));
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author update(AuthorDto dto) {
        Author author = getAuthorById(dto.getId());
        author.setName(dto.getName());
        author.setBirth(dto.getBirth());
        author.setCountry(dto.getCountry());
        author.setBooks(dto.getBooks());
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteAll() {
        authorRepository.deleteAll();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.getAuthorById(id);
    }
}
