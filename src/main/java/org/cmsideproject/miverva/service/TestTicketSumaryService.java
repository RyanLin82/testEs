package org.cmsideproject.miverva.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.TestTicketSumary;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;

public interface TestTicketSumaryService {

//	TestTicketSumary save(TestTicketSumary ticket);
//	
	void save(List<Map<String,Object>> ticket) throws ErrorInputException, ParseException;

//    void delete(TestTicketSumary ticket);
//
    Optional<List<TicketSummarySpringDataDTO>> findByJira(String id);
    
    Optional<TicketSummarySpringDataDTO> findById(String id);
//
//    Iterable<TestTicketSumary> findAll();
}