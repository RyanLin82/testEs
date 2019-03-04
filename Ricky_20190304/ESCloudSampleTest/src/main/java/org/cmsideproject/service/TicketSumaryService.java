package org.cmsideproject.service;

import org.cmsideproject.model.TicketSumaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface TicketSumaryService {

	TicketSumaryDTO save(TicketSumaryDTO book);

    void delete(TicketSumaryDTO book);

    Optional<TicketSumaryDTO> findOne(String id);

    Iterable<TicketSumaryDTO> findAll();
}