package org.cmsideproject.minerva.repo;

import java.util.List;
import java.util.Optional;

import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TestTicketSummaryRepository extends ElasticsearchRepository<TicketSummarySpringDataDTO, String> {

	Optional<List<TicketSummarySpringDataDTO>> findByJira(String ticketNumber);
}