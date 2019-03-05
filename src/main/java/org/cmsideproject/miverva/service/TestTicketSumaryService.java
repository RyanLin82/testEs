package org.cmsideproject.miverva.service;

import java.util.Optional;

import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.TestTicketSumary;

public interface TestTicketSumaryService {

//	TestTicketSumary save(TestTicketSumary ticket);
//	
	void save(String ticket) throws ErrorInputException;

//    void delete(TestTicketSumary ticket);
//
//    Optional<TestTicketSumary> findOne(String id);
//
//    Iterable<TestTicketSumary> findAll();
}