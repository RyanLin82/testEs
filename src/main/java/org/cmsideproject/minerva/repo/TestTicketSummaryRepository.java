package org.cmsideproject.minerva.repo;

import org.cmsideproject.minerva.entity.TestTicketSumary;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TestTicketSummaryRepository extends ElasticsearchRepository<TestTicketSumary, String> {

}