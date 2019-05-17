package org.cmsideproject.minerva.repo;

import java.util.List;
import java.util.Optional;

import org.cmsideproject.minerva.entity.TicketSummary;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SummaryRepository extends ElasticsearchRepository<TicketSummary, String> {

	Optional<List<TicketSummary>> findByJira(String ticketNumber);

	Optional<TicketSummary> findById(String id);
}