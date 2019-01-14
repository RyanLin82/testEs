package org.cmsideproject.minerva.repo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.exception.MinervaException;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
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

	/**
	 * Get data from elasticsearch by index name.
	 * @param indexName
	 * @return if there is any data in the elasticsearch server than return list of data object ; otherwise return empty collection. 
	 * @throws ElasticSearchRequestException 
	 * @throws DTOParseFailException 
	 */
	public Collection<T> getAll(String indexName) throws ElasticSearchRequestException, DTOParseFailException {

		String getUrl = esUrl + "/" + indexName + "/_doc/_search/?size=1000";

		log.info("\n GetAll data from \n Index : [{}] \n Url : [{}]", indexName, esUrl);
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.getForEntity(getUrl, String.class);
		} catch (HttpClientErrorException e) {
			throw new ElasticSearchRequestException(getUrl, e);
		}
		
		

		log.info("\n Respose code: [{}] \n Response body: [{}]", response.getStatusCode(), response.getBody());

		ObjectMapper mapper1 = new ObjectMapper();
		Map<String, Object> responseBodyMap = new HashMap<>();
		try {
			responseBodyMap = mapper1.readValue(response.getBody(), Map.class);
		} catch (IOException e) {
			throw new DTOParseFailException("getAll from " + indexName + " error", e);
		}
		Collection<T> resultList = new ArrayList<>();
		Map responseHits = (Map) responseBodyMap.get("hits");
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) responseHits.get("hits");

		resultList = this.listMapToListObject(dataList);

		log.info("\n GetAll data from \n Index : [{}] \n Url : [{}] \n response body : [{}]", indexName, esUrl, resultList);

		return resultList;

	}

	public void post(String indexName, String insertData) throws Exception {

		if (!checkInputDataFormat(insertData)) {
			log.info("post error\n index name : [{}] \n insertData : [{}]", indexName, insertData);
//			throw new DTOParseFailException("getAll from " + indexName + " error");
		}

		ResponseEntity<String> test = restTemplate.postForEntity(esUrl + "/" + indexName + "/_doc/",
				new HttpEntity<>(insertData, headers), String.class);

		System.out.println(test);
	}

	public void update(String indexName, String updateData, String jiraId) throws Exception {

		if (!checkInputDataFormat(updateData)) {
			log.info("post error");
			throw new Exception("post from " + indexName + " error");
		}

		StringBuilder url = new StringBuilder(esUrl);
		url.append('/').append(indexName).append('/').append("_update_by_query");

		ObjectMapper mopper = new ObjectMapper();
		Map<String, String> updateDataMap = new HashMap<>();
		try {
			updateDataMap = mopper.readValue(updateData, Map.class);
		} catch (IOException e) {
			throw new DTOParseFailException("update from " + indexName + " error", e);
		}

		String updateStrTemplate = "";
		for (Map.Entry map : updateDataMap.entrySet()) {
			updateStrTemplate += "ctx._source['" + map.getKey() + "'] = '" + map.getValue() + "';";
		}
		String updateJson = "{\r\n" + "  \"query\": { \r\n" + "    \"match\": \r\n { \"Jira\" : \"" + jiraId + "\""
				+ "    }\r\n" + "  },\r\n" + "  \"script\": {\r\n" + "    \"inline\": \"" + updateStrTemplate + " \""
				+ "  }\r\n" + "}";

		log.info("URL : [{}] \n Update Json : [{}]", url.toString(), updateJson);
		ResponseEntity<String> response = restTemplate.postForEntity(url.toString(),
				new HttpEntity<>(updateJson, headers), String.class);
		log.info(response.getBody());
	}

	private Collection<T> listMapToListObject(List<Map<String, Object>> dataList) {
		List<T> resultList = new ArrayList<>();
		ModelMapper mapper2 = new ModelMapper();
		int i = 0;
		for (Map<String, Object> map : dataList) {
			T ticket = mapper2.map(map.get("_source"), clazz);
			System.out.println(i++);
			resultList.add(ticket);
		}
		return resultList;
	}

	private boolean checkInputDataFormat(String inputData) {
		if (StringUtils.isEmpty(inputData)) {
			return false;
		}

		T ticket = new ModelMapper().map(inputData, clazz);
		return true;
	}
}
