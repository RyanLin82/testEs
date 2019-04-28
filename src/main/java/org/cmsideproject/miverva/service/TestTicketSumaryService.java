package org.cmsideproject.miverva.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.TestTicketSumary;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;

public interface TestTicketSumaryService {

//	TestTicketSumary save(TestTicketSumary ticket);
//	
	void save(List<Map<String, Object>> ticket) throws ErrorInputException, ParseException, IOException;

//	void saveByDto(List<Map<String, Object>> dataList) throws ErrorInputException, ParseException;
//
//	void saveByDto(Map<String, Object> dataList) throws ParseException;
	
//    void delete(TestTicketSumary ticket);
	List<TicketSummarySpringDataDTO> getByAlias(String aliasName) throws InterruptedException, ExecutionException;

//
	Optional<List<TicketSummarySpringDataDTO>> findByJira(String id);

	Optional<TicketSummarySpringDataDTO> findById(String id);
//
//    Iterable<TestTicketSumary> findAll();
}