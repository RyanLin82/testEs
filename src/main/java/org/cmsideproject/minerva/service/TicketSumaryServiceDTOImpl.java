package org.cmsideproject.minerva.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TicketSumaryServiceDTOImpl extends TicketSumaryService {

	private Logger log = LogManager.getLogger(this.getClass());

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

	/**
	 * Insert datas into certain index.
	 */
	@Override
	public void post(String indexName, String insertData) {

//		if (!this.hasIndex(indexName)) {
//			log.info("post error");
//		}
		ResponseEntity<String> test = restTemplate.postForEntity(esUrl + "/" + indexName + "/_doc/",
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

	/**
	 * Get 1000 datas from certain index.
	 */
	@Override
	public List<TicketSumaryDTO> getAll(String indexName) {

		esUrl = esUrl + "/" + indexName + "/_doc/_search/?size=1000";

		log.info(esUrl);

		ResponseEntity<String> response = restTemplate.getForEntity(esUrl, String.class);
		log.info(response.getBody());
		ObjectMapper mapper1 = new ObjectMapper();
		Map<String, Object> responseBodyMap = new HashMap<>();
		try {
			responseBodyMap = mapper1.readValue(response.getBody(), Map.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TicketSumaryDTO> resultList = new ArrayList<>();
		Map responseHits = (Map) responseBodyMap.get("hits");
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) responseHits.get("hits");

		ModelMapper mapper2 = new ModelMapper();
		for (Map<String, Object> map : dataList) {
			TicketSumaryDTO ticket = mapper2.map(map.get("_source"), TicketSumaryDTO.class);
			resultList.add(ticket);
		}

		log.info("getAll method response : " + response);

		return resultList;

	}

}