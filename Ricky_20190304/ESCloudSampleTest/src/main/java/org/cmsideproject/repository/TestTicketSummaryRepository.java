package org.cmsideproject.repository;

import org.cmsideproject.model.TestTicketSumary;
import org.cmsideproject.model.TicketSumaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TestTicketSummaryRepository extends ElasticsearchRepository<TestTicketSumary, String> {

}