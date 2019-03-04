package org.cmsideproject.miverva.service;

import java.util.Optional;

import org.cmsideproject.minerva.entity.TestTicketSumary;

public interface TestTicketSumaryService {

	TestTicketSumary save(TestTicketSumary ticket);

    void delete(TestTicketSumary ticket);

    Optional<TestTicketSumary> findOne(String id);

    Iterable<TestTicketSumary> findAll();
}