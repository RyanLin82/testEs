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
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.log.MinervaLog;
import org.cmsideproject.log.MinervaLogImp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public abstract class MinervaRepo<T> {

	private Logger log = LogManager.getLogger(this.getClass());
	private MinervaLog log1 = new MinervaLogImp(this.getClass());
	
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
	 * Add datas into ElasticSearch which matches the indexName
	 * 
	 * @param indexName
	 * @param insertData
	 * @return
	 * @throws ErrorInputException
	 */
	public void add(String indexName, String insertData) throws ErrorInputException {

//		T ticket = this.checkInputDataFormat(insertData);

//		isEmpty(ticket);

//		this.validateInputDataMappingEntityAllField(insertData);

		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append(esUrl).append("/").append(indexName).append("/_doc/");

		
//		log.info("\n add data to \n Index : [{}] \n Url : [{}] \n insert data : [{}]", indexName, esUrl, insertData);

		log1.TicketInfo(indexName, "Get all", esUrl);
		
		ResponseEntity<String> response = restTemplate.postForEntity(strbuilder.toString(),
				new HttpEntity<>(insertData, headers), String.class);

//		log.info("\n add data to \n response : [{}] ", response);

		// TODO HTTP ERROR EXCEPTION

	}

	/**
	 * Get data from elasticsearch by index name.
	 * 
	 * @param indexName
	 * @return if there is any data in the elasticsearch server than return list of
	 *         data object ; otherwise return empty collection.
	 * @throws DTOParseFailException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public Collection<T> getAll(String indexName) throws DTOParseFailException {

		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append(esUrl).append("/").append(indexName).append("/_doc/_search/?size=1000");

		String url = strbuilder.toString();

//		log.info("\n GetAll data from \n Index : [{}] \n Url : [{}]", indexName, url);

		log1.TicketInfo(indexName, "Get All", url);
		
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		// TODO HttpClientErrorException

//		log.info("\n Respose code: [{}] \n Response body: [{}]", response.getStatusCode(), response.getBody());

		ObjectMapper mapper1 = new ObjectMapper();
		Map<String, Object> responseBodyMap = new HashMap<>();
		try {
			responseBodyMap = mapper1.readValue(response.getBody(), Map.class);
		} catch (IOException e) {
			throw new DTOParseFailException("response getbody error", e);
		}
		Collection<T> resultList = new ArrayList<>();
		Map responseHits = (Map) responseBodyMap.get("hits");
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) responseHits.get("hits");

		resultList = this.listMapToListObject(dataList);


		log1.TicketInfo(indexName, "Get all", url, resultList);
		
		return resultList;

	}

	/**
	 * Get data from elasticsearch by index name.
	 * 
	 * @param indexName
	 * @return if there is any data in the elasticsearch server than return list of
	 *         data object ; otherwise return empty collection.
	 * @throws ElasticSearchRequestException
	 * @throws DTOParseFailException
	 */
	public Collection<T> get(String indexName, String conditions, boolean fuzzyIndex) throws DTOParseFailException {

		if (fuzzyIndex && !indexName.contains("*")) {
			indexName += "*";
		}

		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append(esUrl).append("/").append(indexName).append("/_doc/_search");

		String getUrl = strbuilder.toString();

		Map<String, String> conditionsMap = this.stringToMap(conditions);

		String getCondition = "";

		for (Map.Entry<String, String> map : conditionsMap.entrySet()) {
			getCondition = "\"" + map.getKey() + ".keyword\" : \"" + map.getValue() + "\",";
		}
		getCondition = getCondition.substring(0, getCondition.length()-1);
		StringBuilder strbuilderConditions = new StringBuilder();
		strbuilderConditions.append("{\r\n \"query\": { \r\n  \"match\": \r\n {").append(getCondition)
				.append("    }\r\n}\r\n}");

		String getConditionJson = strbuilderConditions.toString();

		log.info("URL : [{}] \n get conditions : [{}]", getUrl.toString(), getConditionJson);

		ResponseEntity<String> response = restTemplate.postForEntity(getUrl.toString(),
				new HttpEntity<>(getConditionJson, headers), String.class);

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

		log.info("\n GetAll data from \n Index : [{}] \n Url : [{}] \n response body : [{}]", indexName, esUrl,
				resultList);

		return resultList;

	}

	public void delete(String indexName, String conditions) throws DTOParseFailException {

		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append(esUrl).append("/").append(indexName).append("/_doc/_search");
		String url = strbuilder.toString();
		
		Map<String, String> conditionsMap = this.stringToMap(conditions);

		String deleteCondition = "";

		for (Map.Entry<String, String> map : conditionsMap.entrySet()) {
			deleteCondition = "\"" + map.getKey() + ".keyword\" : \"" + map.getValue() + "\",";
		}
		
//		Map<String, String> conditionsMap = this.stringToMap(conditions);

		String formatConditions = "";
		for (Map.Entry<String, String> map : conditionsMap.entrySet()) {
			formatConditions = "\"" + map.getKey() + ".keyword = '" + map.getValue() + "'\";";
		}

		String deleteJson = "{\r\n" + "  \"query\": { \r\n" + "    \"match\": {\r\n" + formatConditions + "    }\r\n"
				+ "  }\r\n" + "}";

		log.info("URL : [{}] \n Delete Json : [{}]", esUrl.toString(), deleteJson);
		ResponseEntity<String> test = restTemplate.postForEntity(esUrl + "/" + indexName + "/_delete_by_query/",
				new HttpEntity<>(formatConditions, headers), String.class);

	}
//
//	public void update(String indexName, String updateData, String jiraId) throws Exception {
//
//		if (!checkInputDataFormat(updateData)) {
//			log.info("post error");
//			throw new Exception("post from " + indexName + " error");
//		}
//
//		StringBuilder url = new StringBuilder(esUrl);
//		url.append('/').append(indexName).append('/').append("_update_by_query");
//
//		Map<String, String> updateDataMap = new HashMap<>();
//
//		String updateStrTemplate = "";
//		for (Map.Entry map : updateDataMap.entrySet()) {
//			updateStrTemplate += "ctx._source['" + map.getKey() + "'] = '" + map.getValue() + "';";
//		}
//		String updateJson = "{\r\n" + "  \"query\": { \r\n" + "    \"match\": \r\n { \"Jira\" : \"" + jiraId + "\""
//				+ "    }\r\n" + "  },\r\n" + "  \"script\": {\r\n" + "    \"inline\": \"" + updateStrTemplate + " \""
//				+ "  }\r\n" + "}";
//
//		log.info("URL : [{}] \n Update Json : [{}]", url.toString(), updateJson);
//		ResponseEntity<String> response = restTemplate.postForEntity(url.toString(),
//				new HttpEntity<>(updateJson, headers), String.class);
//		log.info(response.getBody());
//	}
//
//	

//	public boolean hasDataInIndex(String indexName, String queryIndex) throws DTOParseFailException {
//		Collection<T> collection = this.getAll(indexName, queryIndex, false);
//
//		return collection == null || collection.isEmpty() ? false : true;
//	}

	private Collection<T> listMapToListObject(List<Map<String, Object>> dataList) {
		List<T> resultList = new ArrayList<>();
		ModelMapper mapper2 = new ModelMapper();
		for (Map<String, Object> map : dataList) {
			T ticket = mapper2.map(map.get("_source"), clazz);
			resultList.add(ticket);
		}
		return resultList;
	}

	private void validateInputDataMappingEntityAllField(String inputData) {
//		if (StringUtils.isEmpty(inputData)) {
//			throw new ErrorInputException(inputData, "input data empty");
//		}

		ModelMapper mapper2 = new ModelMapper();
		mapper2.getConfiguration().setSkipNullEnabled(true);
		T ticket = mapper2.map(inputData, clazz);

		mapper2.validate();

	}

	private T checkInputDataFormat(String inputData) throws ErrorInputException {
		if (StringUtils.isEmpty(inputData)) {
			throw new ErrorInputException(inputData, "input data empty");
		}

		ObjectMapper mapper2 = new ObjectMapper();

		T ticket2 = null;
//		try {
			try {
				ticket2 = mapper2.readValue(inputData, clazz);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		} catch (IOException e) {
//			throw new ErrorInputException(inputData, "input data mapping entity error");
//		}

		isEmpty(ticket2);

		return ticket2;
	}

	abstract void isEmpty(T t) throws ErrorInputException;

	
	/**
	 * String to Map
	 * @param data
	 * @return
	 * @throws DTOParseFailException
	 */
	private Map stringToMap(String data) throws DTOParseFailException {
		ObjectMapper mopper = new ObjectMapper();
		Map<String, String> updateDataMap = new HashMap<>();
		try {
			updateDataMap = mopper.readValue(data, Map.class);
		} catch (IOException e) {
			throw new DTOParseFailException("update from " + "" + " error", e);
		}
		return updateDataMap;
	}

	private String mapToString(Map<String, String> dataMap) {
		return new ModelMapper().map(dataMap, String.class);
	}
}
