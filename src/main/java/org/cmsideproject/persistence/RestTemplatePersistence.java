package org.cmsideproject.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplatePersistence {

	@Value("${file.directory}")
	private String esUrl;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HttpHeaders headers;
	
	public String getUrl() {
		return this.esUrl;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	
}
