package com.github.mnemalotebya.bookstore.service;

import com.github.mnemalotebya.bookstore.model.AuthorRepository;
import com.github.mnemalotebya.bookstore.model.BookRepository;
import com.github.mnemalotebya.bookstore.model.entity.Author;
import com.github.mnemalotebya.bookstore.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public StoreServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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
        Author currentAuthor = authorRepository.findById(id);
        if (currentAuthor != null) {
            currentAuthor.setName(author.getName());
            currentAuthor.setBooks(author.getBooks());
            for (Book book : currentAuthor.getBooks()) {
                book.setAuthor(author);
            }
            return authorRepository.save(currentAuthor);
        }
       return null;
    }

    @Override
    public void deleteAuthorById(int id) {
        Author author = findAuthorById(id);
        if (author != null) authorRepository.deleteById(id);
    }

    @Override
    public void deleteAllAuthors() {
        authorRepository.deleteAll();
    }
}
