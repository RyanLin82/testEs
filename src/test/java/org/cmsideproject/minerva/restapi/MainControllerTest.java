package org.cmsideproject.minerva.restapi;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class MainControllerTest extends AbstractTest {

	org.cmsideproject.minerva.controller.MainController MainController;

	@Before
	public void init() {
		this.setUp();
	}
	
	@Test
	public void insert() throws Exception {
		String uri = "/minerva/TicketSummary/insert";

		Map<String, String> map = new HashMap<>();
		String inputData = "\"baAssignee\": \"Kittrell, Tia jeanine\"," + 
				"            \"baGroup\": \"White, Ebony Summers, John Kittrell, Tia jeanine\"," + 
				"            \"baExcluded\": null," + 
				"            \"baLocation\": \"Offshore\"," + 
				"            \"baSlaDays\": \"-1.82\"," + 
				"            \"baSlaPassed\": null," + 
				"            \"baTotalInProgressTime\": \"0.18\"," + 
				"            \"component\": \"PM_CONFIGURATION\"," + 
				"            \"comment\": null," + 
				"            \"devAssignee\": \"Chang, Polly\"," + 
				"            \"devGroup\": \"Chang, Polly Vijayakumar, Maya\"," + 
				"            \"devExcluded\": null," + 
				"            \"devLocation\": \"Offshore\"," + 
				"            \"devSlaDays\": \"-1.64\"," + 
				"            \"devSlaPassed\": null," + 
				"            \"devTotalInProgressTime\": \"3.41\"," + 
				"            \"devTotalBlockedTime\": \"0.00\"," + 
				"            \"devTotalWaitingTime\": \"0.45\"," + 
				"            \"doneDate\": \"2020-01-03\"," + 
				"            \"exception\": \"0.00\"," + 
				"            \"exceptionTotalTime\": \"0.00\"," + 
				"            \"jira\": \"CZ-10001\"," + 
				"            \"keyword\": \"\"," + 
				"            \"label\": \"\"," +  
				"            \"needMoreInfo\": \"1\"," + 
				"            \"qaAssignee\": \"Wang, Chi-Cheng\"," + 
				"            \"qaGroup\": \"Wang, Chi-Cheng\"," + 
				"            \"qaExcluded\": null," + 
				"            \"qaLocation\": \"Offshore\"," + 
				"            \"qaSlaDays\": \"0.44\"," + 
				"            \"qaSlaPassed\": null," + 
				"            \"qaTotalInProgressTime\": \"3.00\"," + 
				"            \"qaTotalBlockedTime\": null," + 
				"            \"qaTotalWaitingTime\": \"0.44\"," + 
				"            \"redo\": \"0\"," + 
				"            \"status\": \"Done\"," + 
				"            \"testFail\": \"0\"," + 
				"            \"type\": \"Story\"," + 
				"            \"summary\": null";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(inputData)).andReturn();
		System.out.println("tttttt");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is created successfully");
	}
	
//	@Test
//	public void insert() throws Exception {
//		String uri = "/minerva/TicketSummary/insert";
//
//		Map<String, String> map = new HashMap<>();
//		
//		map.put("fromDate", "20180101");
//		map.put("thrDate", "20300101");
//		String inputJson = super.mapToJson(map);
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri)).andReturn();
//		System.out.println("tttttt");
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(201, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Product is created successfully");
//	}
//	
//	@Test
//	public void delete() {
//		String uri = "/minerva/TicketSummary/test2";
//
//		Map<String, String> map = new HashMap<>();
//		
//		map.put("fromDate", "20180101");
//		map.put("thrDate", "20300101");
//		String inputJson = super.mapToJson(map);
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri)).andReturn();
//		System.out.println("tttttt");
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(201, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Product is created successfully");
//	}
}
