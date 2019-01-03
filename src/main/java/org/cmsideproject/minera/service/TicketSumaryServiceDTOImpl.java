package org.cmsideproject.minera.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cmsideproject.minera.entity.TicketSumaryDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TicketSumaryServiceDTOImpl extends TicketSumaryService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

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
		if (!this.hasIndex(indexName)) {
			log.info("post error");
		}

		ResponseEntity<String> test = restTemplate.postForEntity(esUrl + "/" + indexName + "/",
				new HttpEntity<>(insertData, headers), String.class);

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
	public List<TicketSumaryDTO> getAll(String indexName) {

		esUrl = esUrl + "/" + indexName + "/_doc/_search/?size=1000";

		log.info(esUrl);

		ResponseEntity<String> test = restTemplate.getForEntity(esUrl, String.class);
		log.info(test.getBody());
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> participantJsonList = new HashMap<>();
		try {
			participantJsonList = mapper.readValue(test.getBody(), Map.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map str1 = (Map) participantJsonList.get("hits");

		List<TicketSumaryDTO> map2 = new ArrayList<>();
		try {
			map2 = mapper.readValue(str1.toString(), new TypeReference<List<TicketSumaryDTO>>() {
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("getAll method response : " + test);

		return map2;

	}

//	@Autowired
//	RestTempateCus restTemplate;

}