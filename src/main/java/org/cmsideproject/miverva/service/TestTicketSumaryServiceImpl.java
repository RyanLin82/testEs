package org.cmsideproject.miverva.service;

import java.util.Optional;

import org.cmsideproject.minerva.entity.TestTicketSumary;
import org.cmsideproject.minerva.repo.TestTicketSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTicketSumaryServiceImpl implements TestTicketSumaryService {

    private TestTicketSummaryRepository ticketRepository;

    @Autowired
    public void setTicketRepository(TestTicketSummaryRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TestTicketSumary save(TestTicketSumary book) {
        return ticketRepository.save(book);
    }

    public void delete(TestTicketSumary book) {
    	ticketRepository.delete(book);
    }

    public Optional<TestTicketSumary> findOne(String id) {
        return ticketRepository.findById(id);
    }

    public Iterable<TestTicketSumary> findAll() {
        return ticketRepository.findAll();
    }
}