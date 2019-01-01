package org.cmsideproject.minera.service;

import org.apache.commons.lang.StringUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;


public class Validation {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HttpHeaders httpHeaders;
	
	boolean hasIndex(String indexName){
		String url = "https://1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io:9243/"+indexName+"/_doc/";
//	    ResponseEntity<String> test = restTemplate.exchange(uri, HttpMethod.POST, "FF", String.class);
		String result = restTemplate.getForObject(url, String.class);
	    
		if(StringUtils.isEmpty(result)){
			log.info("index not found, index name:" + indexName);
			return false;
		}
		
		return true;
	}
	
	void checkData(){};
}
