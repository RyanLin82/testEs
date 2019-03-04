package org.cmsideproject.service;

import org.cmsideproject.model.TestTicketSumary;
import org.cmsideproject.model.TicketSumaryDTO;
import org.cmsideproject.repository.BookRepository;
import org.cmsideproject.repository.TestTicketSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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