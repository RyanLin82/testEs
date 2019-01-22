package org.cmsideproject.miverva.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.cmsideproject.minerva.repo.TicketSumaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class JiraTicketService {

	@Autowired
	TicketSumaryRepo ticketSumaryRepo;

	public void insertData(String indexName, String insertData) throws ErrorInputException, ElasticSearchRequestException {
		ticketSumaryRepo.add(indexName, insertData);
	}

	public List<TicketSumaryDTO> getAll(String indexName) {
		if (StringUtils.isEmpty(indexName)) {
			return new ArrayList<>();
		}
		return (List<TicketSumaryDTO>) ticketSumaryRepo.getAll(indexName);
	}

//	public List<TicketSumaryDTO> getAll(String indexName, String queryIndex, boolean fuzzyIndex)
//			throws DTOParseFailException {
//		if (StringUtils.isEmpty(indexName) || StringUtils.isEmpty(queryIndex)) {
//			return new ArrayList<>();
//		}
//		return (List<TicketSumaryDTO>) ticketSumaryRepo.getAll(indexName, queryIndex, fuzzyIndex);
//	}

//	public void update(String indexName, String updateData, String jiraId) throws Exception {
//		if (StringUtils.isEmpty(indexName) || StringUtils.isEmpty(updateData) || StringUtils.isEmpty(jiraId)) {
//		}
//		ticketSumaryRepo.update(indexName, updateData, jiraId);
//	}

//	public void delete(String indexName, String conditions) throws DTOParseFailException {
//		ticketSumaryRepo.delete(indexName, conditions);
//	}
//
	public void add(String indexName, String insertData) throws ErrorInputException, ElasticSearchRequestException{
		ticketSumaryRepo.add(indexName, insertData);
	}
}
