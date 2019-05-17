package org.cmsideproject.minerva.integration.restapi;


import java.util.ArrayList;

import org.cmsideproject.component.AliasSetting;
import org.cmsideproject.component.TicketIndicesAlias;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.service.TicketSumaryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(MockitoJUnitRunner.class)
public class controllerTest2 {

	org.cmsideproject.minerva.controller.MainController MainController;

//	private MockMvc mockMvc;
	
	
	@Mock
	AliasSetting aliasSetting;
	
	@Mock
	TicketIndicesAlias ticketIndices;
	
	@Mock
	private TicketSumaryService testTicketSumaryService;

	@InjectMocks 
	org.cmsideproject.minerva.controller.MainController mainController;
	
	
	
	@Before
	public void init() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Transactional
	public void insert() throws Exception {
		String uri = "/minerva/TicketSummary/insert";

		Mockito.when(testTicketSumaryService.getByDate(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(new ArrayList<>());
		MinervaResponse aaa = mainController.findByDate("20180101", "20300101");
		
		
//		mainController.insert(new ArrayList<>());
	}
	
//	@Test
//	public void findByTicketNum() throws Exception {
//		String uri = "/minerva/TicketSummary/findByTicketNumber";
//
//		String ticketNum = "CZ-00001";
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(ticketNum)).andReturn();
//		
//		Optional<List<TicketSummarySpringDataDTO>> result = Optional.empty();
//		Mockito.when(testTicketSummaryRepository.findByJira(ticketNum)).thenReturn(result);
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(200, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Product is created successfully");
//	}
//	
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

