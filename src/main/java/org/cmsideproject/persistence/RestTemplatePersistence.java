//package org.cmsideproject.persistence;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public abstract class RestTemplatePersistence {
//
//	@Value("${file.directory}")
//	protected String esUrl;
//
//	@Autowired
//	protected RestTemplate restTemplate;
//
//	@Autowired
//	protected HttpHeaders headers;
//	
////	public RestTemplatePersistence() {}
////
////	public String getEsUrl() {
////		return esUrl;
////	}
////
////	public void setEsUrl(String esUrl) {
////		this.esUrl = esUrl;
////	}
////
////	public RestTemplate getRestTemplate() {
////		return restTemplate;
////	}
////
////	public void setRestTemplate(RestTemplate restTemplate) {
////		this.restTemplate = restTemplate;
////	}
////
////	public HttpHeaders getHeaders() {
////		return headers;
////	}
////
////	public void setHeaders(HttpHeaders headers) {
////		this.headers = headers;
////	}
//	
//	
//}
