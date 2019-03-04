package org.cmsideproject.repository;

import org.cmsideproject.model.Boosk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Boosk, String> {

    Page<Boosk> findByAuthor(String author, Pageable pageable);

    List<Boosk> findByTitle(String title);

}