package org.cmsideproject.repository;

import org.cmsideproject.model.TicketSumaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TicketSummaryRepository extends ElasticsearchRepository<TicketSumaryDTO, String> {

}