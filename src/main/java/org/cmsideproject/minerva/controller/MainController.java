package org.cmsideproject.minerva.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cmsideproject.Suffix;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.miverva.service.TestTicketSumaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
public class MainController {

	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	private TestTicketSumaryService testTicketSumaryService;
	
	@Autowired
	private Suffix suffix;

//    @RequestMapping(method = RequestMethod.POST)
//	public @ResponseBody ResponseEntity<String> addNewTicket (@RequestBody List<TestTicketSumary> tickets){
////    	es.putMapping(TestTicketSumary.class);
//    	
//		suffix.setValue("sum_201809");
//		
//		StringBuilder s = new StringBuilder();
//		for(TestTicketSumary ticket : tickets) {
//			testTicketSumaryService.save(ticket);
//			s.append(ticket.toString());
//			s.append("\n");
//		}
//		
//		return new ResponseEntity<String>("POST Response\n"+s.toString(), HttpStatus.OK);
//	}

//	@RequestMapping(method = RequestMethod.POST)
//	public @ResponseBody ResponseEntity<String> addNewTicket(@RequestParam String jiraId, @RequestParam String type,
//			@RequestParam String component, @RequestParam String label, @RequestParam String status,
//			@RequestParam String ba_assignee, @RequestParam String dev_assignee, @RequestParam String qa_assignee) {
//
//		es.putMapping(TestTicketSumary.class);
//
//		suffix.setValue("sum_201814");
//
////		TestTicketSumary summary = 
////				new TestTicketSumaryBuilder()
////					.setJiraId(jiraId)
////					.setType(type)
////					.setComponent(component)
////					.setLabel(label)
////					.setStatus(status)
////					.setBa_assignee(ba_assignee)
////					.setDev_assignee(dev_assignee)
////					.setQa_assignee(qa_assignee)
////					.build();
//
//		TestTicketSumary summary = new TestTicketSumaryBuilder().setJiraId("ggtest").setType("ERE11")
//				.setComponent("ERE11").setLabel("ERE").setStatus("ERE").setBa_assignee("ERE").setDev_assignee("ERE")
//				.setQa_assignee("ERE").build();
//
//		testTicketSumaryService.save(summary);
//
//		return new ResponseEntity<String>("POST Response", HttpStatus.OK);
//	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	public @ResponseBody ResponseEntity<String> get() {
//		suffix.setValue("sum_201809");
//
//		Iterable<TestTicketSumary> tickets = testTicketSumaryService.findAll();
//		tickets.forEach(x -> System.out.println(x));
//
//		return new ResponseEntity<String>("GET Response", HttpStatus.OK);
//	}
	
	@RequestMapping(value = "minerva/TicketSummary/post", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse postTicketSumary(@RequestBody List<Map<String,Object>> data) throws ErrorInputException{
		MinervaResponse minervaResponse = new MinervaResponse();
		testTicketSumaryService.save(data);
		return minervaResponse;
	}
	
	@RequestMapping(value = "minerva/TicketSummary/getOne", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse getOneById(@RequestBody String ticketNumber) throws ErrorInputException{
		MinervaResponse minervaResponse = new MinervaResponse();
//		testTicketSumaryService.findById(ticketNumber).get();
		List list = new ArrayList<>();
		list.add(testTicketSumaryService.findByJira(ticketNumber).get());
		minervaResponse.setData(list);
		return minervaResponse;
	}
}