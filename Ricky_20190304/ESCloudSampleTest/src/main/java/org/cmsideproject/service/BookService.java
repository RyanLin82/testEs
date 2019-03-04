package org.cmsideproject.service;

import org.cmsideproject.model.Boosk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Boosk save(Boosk book);

    void delete(Boosk book);

    Optional<Boosk> findOne(String id);

    Iterable<Boosk> findAll();

    Page<Boosk> findByAuthor(String author, PageRequest pageRequest);

    List<Boosk> findByTitle(String title);

}