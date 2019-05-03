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
	public void findById() throws Exception {
		String uri = "localhost:8090/minerva/TicketSummary/findByDate";

		Map<String, String> map = new HashMap<>();
		
		map.put("fromDate", "20180101");
		map.put("thrDate", "20300101");
		String inputJson = super.mapToJson(map);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is created successfully");
	}
}
