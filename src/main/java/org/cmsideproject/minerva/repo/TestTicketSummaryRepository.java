package org.cmsideproject.minerva.repo;

import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TestTicketSummaryRepository extends ElasticsearchRepository<TicketSummarySpringDataDTO, String> {

}