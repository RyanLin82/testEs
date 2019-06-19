package org.cmsideproject.minerva.integration.restapi;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cmsideproject.component.AliasSetting;
import org.cmsideproject.component.TicketIndicesAlias;
import org.cmsideproject.minerva.entity.TicketSummary;
import org.cmsideproject.minerva.repo.SummaryRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainControllerTest extends AbstractTest {

	private Logger log = LogManager.getLogger(this.getClass());
	org.cmsideproject.minerva.controller.Controller MainController;

//	private MockMvc mockMvc;

	@Mock
	SummaryRepository testTicketSummaryRepository;

	@Mock
	AliasSetting aliasSetting;

	@Mock
	TicketIndicesAlias ticketIndices;

//	@InjectMocks 
//	org.cmsideproject.minerva.controller.MainController mainController;

	private static List<Map<String, Object>> data;
	private static List<TicketSummary> dataEntity;
	private static String dataJson;

	@BeforeClass
	public  static void setData() throws JsonParseException, JsonMappingException, IOException {
		preparedData();
	}

	@Before
	public void init() throws JsonParseException, JsonMappingException, IOException {

		MockitoAnnotations.initMocks(this);
		this.setUp();

	}

	private static void preparedData() throws JsonParseException, JsonMappingException, IOException {
		dataJson = "[{\"baAssignee\": \"Kittrell, Tia jeanine\","
				+ "            \"baGroup\": \"White, Ebony Summers, John Kittrell, Tia jeanine\","
				+ "            \"baExcluded\": null," + "            \"baLocation\": \"Offshore\","
				+ "            \"baSlaDays\": \"-1.82\"," + "            \"baSlaPassed\": null,"
				+ "            \"baTotalInProgressTime\": \"0.18\","
				+ "            \"component\": \"PM_CONFIGURATION\"," + "            \"comment\": null,"
				+ "            \"devAssignee\": \"Chang, Polly\","
				+ "            \"devGroup\": \"Chang, Polly Vijayakumar, Maya\"," + "            \"devExcluded\": null,"
				+ "            \"devLocation\": \"Offshore\"," + "            \"devSlaDays\": \"-1.64\","
				+ "            \"devSlaPassed\": null," + "            \"devTotalInProgressTime\": \"3.41\","
				+ "            \"devTotalBlockedTime\": \"0.00\"," + "            \"devTotalWaitingTime\": \"0.45\","
				+ "            \"doneDate\": \"2020-01-03\"," + "            \"exception\": \"0.00\","
				+ "            \"exceptionTotalTime\": \"0.00\"," + "            \"jira\": \"CZ-20001\","
				+ "            \"keyword\": \"\"," + "            \"label\": \"\","
				+ "            \"needMoreInfo\": \"1\"," + "            \"qaAssignee\": \"Wang, Chi-Cheng\","
				+ "            \"qaGroup\": \"Wang, Chi-Cheng\"," + "            \"qaExcluded\": null,"
				+ "            \"qaLocation\": \"Offshore\"," + "            \"qaSlaDays\": \"0.44\","
				+ "            \"qaSlaPassed\": null," + "            \"qaTotalInProgressTime\": \"3.00\","
				+ "            \"qaTotalBlockedTime\": null," + "            \"qaTotalWaitingTime\": \"0.44\","
				+ "            \"redo\": \"0\"," + "            \"status\": \"Done\","
				+ "            \"testFail\": \"0\"," + "            \"type\": \"Story\","
				+ "            \"summary\": null}]";

		ObjectMapper mapper = new ObjectMapper();
		data = mapper.readValue(dataJson, new TypeReference<List<Map<String, Object>>>() {
		});

		List<TicketSummary> resultList = new ArrayList<>();
		ModelMapper mapper2 = new ModelMapper();
		for (Map<String, Object> map : data) {
			TicketSummary ticket = mapper2.map(map, TicketSummary.class);
			resultList.add(ticket);
		}
		dataEntity = resultList;

	}

	@Test
	public void insert() throws Exception {
		String uri = "/minerva/TicketSummary/add";
		log.info("======start=====\nmethod name:[{}]\nurl: [{}]\ninputData:[{}]", "insert", uri, dataJson);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(dataJson))
				.andReturn();
		System.out.println("tttttt");

		Mockito.when(testTicketSummaryRepository.save(Mockito.any(TicketSummary.class)));
		int status = mvcResult.getResponse().getStatus();
		
		
		assertEquals(200, status);
		log.info("return status code:[{}]\nresponse data: [{}]======end=====\\n", status, "");
		String content = mvcResult.getResponse().getContentAsString();
	}

	@Test
	public void findByTicketNum() throws Exception {
		String uri = "/minerva/TicketSummary/findByTicketNumber";
		log.info("======start=====\nmethod name:[{}]\nurl: [{}]\ninputData:[{}]", "findByTicketNumber", uri, "(ticketNumber,"+dataEntity.get(0).getJira()+")");
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).param("ticketNumber", dataEntity.get(0).getJira())).andReturn();
		
		Optional<List<TicketSummary>> result = Optional.empty();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		log.info("return status code:[{}]\nresponse data: [{}]======end=====\\n", status, "");
	}
	
	@Test
	public void findByDate() throws Exception {
		String uri = "/minerva/TicketSummary/findByDate";
		String fromDate = "20180101";
		String thrDate = "20300101";
		log.info("======start=====\nmethod name:[{}]\nurl: [{}]\ninputData:[{}]", "findByDate", uri, "fromDate: "+fromDate+"thrDate: "+thrDate);
		
		String inputdata = "\"fromDate\": \"20180101\", \"thrDate\": \"20300101\"";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).param("fromDate", fromDate).param("thrDate", thrDate)).andReturn();;

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		log.info("return status code:[{}]\nresponse data: [{}]======end=====\\n", status, "");
		
	}
	
	@Test
	public void update() throws Exception {
		String uri = "/minerva/TicketSummary/update";
		log.info("======start=====\nmethod name:[{}]\nurl: [{}]\ninputData:[{}]", "update", uri);
		
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(dataJson))
				.andReturn();
		System.out.println("tttttt");

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		log.info("return status code:[{}]\nresponse data: [{}]======end=====\\n", status, "");
		
//		assertEquals(content, "Product is created successfully");

//		mainController.insert(new ArrayList<>());
	}
//	
	@Test
	public void setAlias() throws Exception {
		String uri = "/minerva/TicketSummary/setAlias";
		log.info("======start=====\nmethod name:[{}]\nurl: [{}]\ninputData:[{}]", "setAlias", uri);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).param("aliasName", "test_ryan_2020").param("indexName", "test_ryan_202001")).andReturn();
		System.out.println("tttttt");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is created successfully");
	}
	
	@Test
	public void delete() throws Exception {
		String uri = "/minerva/TicketSummary/delete";
		log.info("======start=====\nmethod name:[{}]\nurl: [{}]\ninputData:[{}]", "delete", uri);
		
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(this.dataJson)).andReturn();
		System.out.println("tttttt");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Product is created successfully");
	}
}
