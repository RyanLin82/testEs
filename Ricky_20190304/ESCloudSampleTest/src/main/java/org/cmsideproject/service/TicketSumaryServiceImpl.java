package org.cmsideproject.service;

import org.cmsideproject.model.TicketSumaryDTO;
import org.cmsideproject.repository.BookRepository;
import org.cmsideproject.repository.TicketSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketSumaryServiceImpl implements TicketSumaryService {

    private TicketSummaryRepository ticketRepository;

    @Autowired
    public void setTicketRepository(TicketSummaryRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketSumaryDTO save(TicketSumaryDTO book) {
        return ticketRepository.save(book);
    }

    public void delete(TicketSumaryDTO book) {
    	ticketRepository.delete(book);
    }

    public Optional<TicketSumaryDTO> findOne(String id) {
        return ticketRepository.findById(id);
    }

    public Iterable<TicketSumaryDTO> findAll() {
        return ticketRepository.findAll();
    }
}