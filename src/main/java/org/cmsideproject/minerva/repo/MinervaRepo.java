package org.cmsideproject.minerva.repo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public abstract class MinervaRepo<T> {

	private Logger log = LogManager.getLogger(this.getClass());

	@Value("${file.directory}")
	private String esUrl;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HttpHeaders headers;

	private Class<T> clazz;

	public MinervaRepo(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Collection<T> getAll(String indexName) {

		String getUrl = esUrl + "/" + indexName + "/_doc/_search/?size=1000";

		log.info(esUrl);

		ResponseEntity<String> response = restTemplate.getForEntity(getUrl, String.class);

		log.info(response.getBody());

		ObjectMapper mapper1 = new ObjectMapper();
		Map<String, Object> responseBodyMap = new HashMap<>();
		try {
			responseBodyMap = mapper1.readValue(response.getBody(), Map.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<T> resultList = new ArrayList<>();
		Map responseHits = (Map) responseBodyMap.get("hits");
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) responseHits.get("hits");

//		ModelMapper mapper2 = new ModelMapper();
//		for (Map<String, Object> map : dataList) {
//			T ticket = mapper2.map(map.get("_source"), T.);
//			resultList.add(ticket);
//		}

		resultList = this.listMapToListObject(dataList);

		log.info("getAll method response : " + response);

		return resultList;

	}

	private Collection<T> listMapToListObject(List<Map<String, Object>> dataList) {
		List<T> resultList = new ArrayList<>();
		ModelMapper mapper2 = new ModelMapper();
		int flag = 0;
		for (Map<String, Object> map : dataList) {
			T ticket = mapper2.map(map.get("_source"), clazz);
			resultList.add(ticket);
			System.out.println(flag++);
		}
		return resultList;
	}

	private boolean checkData(String data) {
		ObjectMapper mapper1 = new ObjectMapper();
		T responseBodyMap = mapper1.readValue(data, clazz.getClass());
	}
}
