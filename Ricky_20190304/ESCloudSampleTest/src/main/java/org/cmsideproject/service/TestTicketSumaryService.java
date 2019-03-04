package org.cmsideproject.service;

import org.cmsideproject.model.TestTicketSumary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface TestTicketSumaryService {

	TestTicketSumary save(TestTicketSumary ticket);

    void delete(TestTicketSumary ticket);

    Optional<TestTicketSumary> findOne(String id);

    Iterable<TestTicketSumary> findAll();
}