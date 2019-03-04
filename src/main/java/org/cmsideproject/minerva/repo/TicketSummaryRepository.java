package org.cmsideproject.minerva.repo;

import org.cmsideproject.minerva.entity.TicketSumaryDTO2;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketSummaryRepository extends ElasticsearchRepository<TicketSumaryDTO2, String> {

}