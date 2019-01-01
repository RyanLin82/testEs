package org.cmsideproject.minera.service;

import org.cmsideproject.minera.entity.TicketSumaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketSumaryServiceDTOImpl extends TicketSumaryService {

	@Value("${file.directory}")
	private String esUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
    HttpHeaders headers;

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
	public void post(String indexName, String insertData) {
		if(!this.hasIndex(indexName)){
			log.info("post error");
		}
		
        ResponseEntity<String> test = restTemplate.postForEntity(esUrl+"/"+indexName+"/", new HttpEntity<>(insertData, headers), String.class);
	    
	    System.out.println(test);
	}

	@Override
	public Iterable<TicketSumaryDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(String indexName, String insertData, String dataIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String indexName, String insertData, String dataIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAll(String indexName) {
		// TODO Auto-generated method stub
		
	}
	
//	@Autowired
//	RestTempateCus restTemplate;
	



}