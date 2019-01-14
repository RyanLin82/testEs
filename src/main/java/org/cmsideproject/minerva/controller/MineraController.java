package org.cmsideproject.minerva.controller;

import java.util.ArrayList;
import java.util.List;

import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.cmsideproject.minerva.repo.TicketSumaryRepo;
import org.cmsideproject.minerva.service.TicketSumaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MineraController {

//	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	TicketSumaryService ticketSumaryService;
	
	@Autowired
	TicketSumaryRepo ticketSumaryRepo ;

//	@RequestMapping(value = "minera/test", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//	public String test() {
//
//		String uri = "https://1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io:9243/sum_201808/_doc/";
//		String json = "{\"Jira\":\"Ryan-11112\",\"Type\":\"Story\",\"Component\":\"Bridge\",\"Keyword\":\"\",\"Label\":\"Tier2\",\"Status\":\"Done\",\"Need More Info\":0,\"Test Fail\":0,\"Redo\":0,\"BA Assignee\":\"Singh, Akash\",\"BA Group\":\"Kittrell, Tia jeanine\\nSingh, Akash\",\"Total BA In Progress Time (days)\":2.2,\"SLA-BA (days)\":-0.3,\"SLA-BA(T/F)\":\"TRUE\",\"DEV Assignee\":\"Lee, Chi-Ching\",\"DEV Location\":\"Offshore\",\"DEV Group\":\"Lee, Chi-Ching\\nJean Su\",\"Total Wait For DEV Time (days)\":0.03,\"Total DEV In Progress Time (days)\":1.64,\"Total DEV Blocked\":0,\"SLA-DEV (days)\":-1.83,\"SLA-DEV\":\"TRUE\",\"QA Assignee\":\"Wang, Chi-Cheng\",\"QA Group\":\"Wang, Chi-Cheng\",\"Total Wait For QA Time (days)\":0.82,\"Total QA In Progress Time (days)\":0.28,\"SLA-QA (days)\":-0.41,\"SLA-QA(T/F)\":\"TRUE\",\"Exception #\":2,\"Total Exception Time\":0.15}";
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("elastic", "q6KUX12lvelsACXVMGydkKmb"));
////	    ResponseEntity<String> test = restTemplate.exchange(uri, HttpMethod.POST, "FF", String.class);
//
//		HttpHeaders headers = new HttpHeaders();
//		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//		headers.setContentType(type);
//		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
//
//		ResponseEntity<String> test = restTemplate.postForEntity(uri, new HttpEntity<>(json, headers), String.class);
//
//		System.out.println(test);
//
//		return "OK";
//
//	}

	/**
	 * Insert datas into certain index.
	 * @param index
	 * @param data
	 * @return 
	 */
	@RequestMapping(value = "minerva/post/{index}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String postIndex(@PathVariable("index") String index, @RequestBody String data) {

		ticketSumaryService.post(index, data);

		return "OK";

	}

	/**
	 * Get 1000 datas from certain index.
	 * @param index
	 * @return if there is data in certain index then return data value; otherwise return empty arraylist.
	 * @throws ElasticSearchRequestException 
	 */
	@RequestMapping(value = "minerva/get/{index}", method = RequestMethod.GET)
	public List<TicketSumaryDTO> getAll(@PathVariable("index") String index) {

		String returnMsg = "";
		List<TicketSumaryDTO> reponse = null;
		try {
			reponse = (List<TicketSumaryDTO>) ticketSumaryRepo.getAll(index);
		} catch (ElasticSearchRequestException e) {
			System.out.println("111");
		}
//		List<TicketSumaryDTO> reponse = ticketSumaryService.getAll(index);
//
//		if (StringUtils.isEmpty(reponse)) {
//			return new ArrayList<>();
//		}

		return reponse;

	}
	
	/**
	 * Insert datas into certain index.
	 * @param index
	 * @param data
	 * @return 
	 */
	@RequestMapping(value = "minerva/update/{index}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String updateDataByJiraNum(@PathVariable("index") String indexName, @RequestBody String data, @RequestParam(value = "jiraNum") String jiraNum) {

//		ticketSumaryService.update(indexName, data, jiraNum);

		return "OK";

	}
}
