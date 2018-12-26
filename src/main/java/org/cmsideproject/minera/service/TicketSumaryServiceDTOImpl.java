package org.cmsideproject.minera.service;

import org.cmsideproject.minera.entity.TicketSumaryDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TicketSumaryServiceDTOImpl implements TicketSumaryService {

	@Value("${file.directory}")
	private String esUrl;
	
	
	@Override
	public TicketSumaryDTO save(TicketSumaryDTO TicketSumary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TicketSumaryDTO TicketSumary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<TicketSumaryDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postData(String indexName, String insertData) {
		// TODO Auto-generated method stub
		
	}




}