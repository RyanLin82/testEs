package org.cmsideproject.minera.controller;

import java.util.List;

import org.cmsideproject.minera.entity.TicketSumaryDTO;
import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MineraController {

	private Logger log = Logger.getLogger(this.getClass());

//	@Autowired
//	InsertJsonData insertListData;
//	
//	
//	@ApiOperation(value="创建用户", notes="根据User对象创建用户")
//	@RequestMapping(value = "minera/hello", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	public String setJiraTicket(@RequestBody Map<String, String>[] jiraJson) {
//		
//		insertListData.insertTicketSumaryListIntoEs(jiraJson);
//		
//		return "insert success";
//
//	}
//	
//	
//	@RequestMapping(value = "minera/hello2", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	public String setJiraTicket(@RequestBody List<TicketSumary> jiraJson) {
//		
//		
//		System.out.println("testt" + jiraJson);
//
//		return "OK";
//
//	}
//TicketSumaryDTO
	@RequestMapping(value = "minera/test", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String test() {
		
		
		String uri = "https://1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io:9243/sum_201808/_doc/";
		String json = "{\"Jira\":\"Ryan-11112\",\"Type\":\"Story\",\"Component\":\"Bridge\",\"Keyword\":\"\",\"Label\":\"Tier2\",\"Status\":\"Done\",\"Need More Info\":0,\"Test Fail\":0,\"Redo\":0,\"BA Assignee\":\"Singh, Akash\",\"BA Group\":\"Kittrell, Tia jeanine\\nSingh, Akash\",\"Total BA In Progress Time (days)\":2.2,\"SLA-BA (days)\":-0.3,\"SLA-BA(T/F)\":\"TRUE\",\"DEV Assignee\":\"Lee, Chi-Ching\",\"DEV Location\":\"Offshore\",\"DEV Group\":\"Lee, Chi-Ching\\nJean Su\",\"Total Wait For DEV Time (days)\":0.03,\"Total DEV In Progress Time (days)\":1.64,\"Total DEV Blocked\":0,\"SLA-DEV (days)\":-1.83,\"SLA-DEV\":\"TRUE\",\"QA Assignee\":\"Wang, Chi-Cheng\",\"QA Group\":\"Wang, Chi-Cheng\",\"Total Wait For QA Time (days)\":0.82,\"Total QA In Progress Time (days)\":0.28,\"SLA-QA (days)\":-0.41,\"SLA-QA(T/F)\":\"TRUE\",\"Exception #\":2,\"Total Exception Time\":0.15}";
		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("elastic", "q6KUX12lvelsACXVMGydkKmb"));
//	    ResponseEntity<String> test = restTemplate.exchange(uri, HttpMethod.POST, "FF", String.class);
	   
	    
	    HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		
        ResponseEntity<String> test = restTemplate.postForEntity(uri, new HttpEntity<>(json, headers), String.class);
	    
	    System.out.println(test);

		return "OK";

	}
	
//	@RequestMapping(value = "minera/testJson", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	public String testJson(@RequestBody List<TicketSumaryDTO> jiraJsons) {
//		
//		
//		for(TicketSumaryDTO jiraJson : jiraJsons) {
//			ModelMapper mpr = 
//		}
//		
//		String uri = "https://1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io:9243/sum_201808/_doc/";
//		String json = "{\"Jira\":\"Ryan-11112\",\"Type\":\"Story\",\"Component\":\"Bridge\",\"Keyword\":\"\",\"Label\":\"Tier2\",\"Status\":\"Done\",\"Need More Info\":0,\"Test Fail\":0,\"Redo\":0,\"BA Assignee\":\"Singh, Akash\",\"BA Group\":\"Kittrell, Tia jeanine\\nSingh, Akash\",\"Total BA In Progress Time (days)\":2.2,\"SLA-BA (days)\":-0.3,\"SLA-BA(T/F)\":\"TRUE\",\"DEV Assignee\":\"Lee, Chi-Ching\",\"DEV Location\":\"Offshore\",\"DEV Group\":\"Lee, Chi-Ching\\nJean Su\",\"Total Wait For DEV Time (days)\":0.03,\"Total DEV In Progress Time (days)\":1.64,\"Total DEV Blocked\":0,\"SLA-DEV (days)\":-1.83,\"SLA-DEV\":\"TRUE\",\"QA Assignee\":\"Wang, Chi-Cheng\",\"QA Group\":\"Wang, Chi-Cheng\",\"Total Wait For QA Time (days)\":0.82,\"Total QA In Progress Time (days)\":0.28,\"SLA-QA (days)\":-0.41,\"SLA-QA(T/F)\":\"TRUE\",\"Exception #\":2,\"Total Exception Time\":0.15}";
//	    RestTemplate restTemplate = new RestTemplate();
//	    restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("elastic", "q6KUX12lvelsACXVMGydkKmb"));
////	    ResponseEntity<String> test = restTemplate.exchange(uri, HttpMethod.POST, "FF", String.class);
//	   
//	    
//	    HttpHeaders headers = new HttpHeaders();
//        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//        headers.setContentType(type);
//        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
//		
//        ResponseEntity<String> test = restTemplate.postForEntity(uri, new HttpEntity<>(json, headers), String.class);
//	    
//	    System.out.println(test);
//
//		return "OK";
//
//	}

	
	@RequestMapping(value = "minera/post/{index}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String postIndex(@RequestParam("index") String index, String data) {
		
		
		String uri = "https://1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io:9243/sum_201808/_doc/";
		String json = "{\"Jira\":\"Ryan-11112\",\"Type\":\"Story\",\"Component\":\"Bridge\",\"Keyword\":\"\",\"Label\":\"Tier2\",\"Status\":\"Done\",\"Need More Info\":0,\"Test Fail\":0,\"Redo\":0,\"BA Assignee\":\"Singh, Akash\",\"BA Group\":\"Kittrell, Tia jeanine\\nSingh, Akash\",\"Total BA In Progress Time (days)\":2.2,\"SLA-BA (days)\":-0.3,\"SLA-BA(T/F)\":\"TRUE\",\"DEV Assignee\":\"Lee, Chi-Ching\",\"DEV Location\":\"Offshore\",\"DEV Group\":\"Lee, Chi-Ching\\nJean Su\",\"Total Wait For DEV Time (days)\":0.03,\"Total DEV In Progress Time (days)\":1.64,\"Total DEV Blocked\":0,\"SLA-DEV (days)\":-1.83,\"SLA-DEV\":\"TRUE\",\"QA Assignee\":\"Wang, Chi-Cheng\",\"QA Group\":\"Wang, Chi-Cheng\",\"Total Wait For QA Time (days)\":0.82,\"Total QA In Progress Time (days)\":0.28,\"SLA-QA (days)\":-0.41,\"SLA-QA(T/F)\":\"TRUE\",\"Exception #\":2,\"Total Exception Time\":0.15}";
		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("elastic", "q6KUX12lvelsACXVMGydkKmb"));
//	    ResponseEntity<String> test = restTemplate.exchange(uri, HttpMethod.POST, "FF", String.class);
	   
	    
	    HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		
        ResponseEntity<String> test = restTemplate.postForEntity(uri, new HttpEntity<>(json, headers), String.class);
	    
	    System.out.println(test);

		return "OK";

	}
}
