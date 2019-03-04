package org.cmsideproject.service;

import org.cmsideproject.model.Boosk;
import org.cmsideproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Boosk save(Boosk book) {
        return bookRepository.save(book);
    }

    public void delete(Boosk book) {
        bookRepository.delete(book);
    }

    public Optional<Boosk> findOne(String id) {
        return bookRepository.findById(id);
    }

    public Iterable<Boosk> findAll() {
        return bookRepository.findAll();
    }

    public Page<Boosk> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    public List<Boosk> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

}