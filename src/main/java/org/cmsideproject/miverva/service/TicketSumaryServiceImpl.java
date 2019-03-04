package org.cmsideproject.miverva.service;

import java.util.Optional;

import org.cmsideproject.minerva.entity.TicketSumaryDTO2;
import org.cmsideproject.minerva.repo.TicketSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketSumaryServiceImpl implements TicketSumaryService {
	@Autowired
	private TicketSummaryRepository ticketRepository;

	public TicketSumaryDTO2 save(TicketSumaryDTO2 book) {
		return ticketRepository.save(book);
	}

	public void delete(TicketSumaryDTO2 book) {
		ticketRepository.delete(book);
	}

	public Optional<TicketSumaryDTO2> findOne(String id) {
		return ticketRepository.findById(id);
	}

	public Iterable<TicketSumaryDTO2> findAll() {
		return ticketRepository.findAll();
	}
}