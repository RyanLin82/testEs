package org.cmsideproject.controller;

import java.util.List;

import org.cmsideproject.Suffix;
import org.cmsideproject.model.TestTicketSumary;
import org.cmsideproject.model.TestTicketSumary.TestTicketSumaryBuilder;
import org.cmsideproject.service.TestTicketSumaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/demo")
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
    
    @RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> addNewTicket (@RequestParam String jiraId,
			@RequestParam String type, @RequestParam String component,
			@RequestParam String label, @RequestParam String status,
			@RequestParam String ba_assignee, @RequestParam String dev_assignee,
			@RequestParam String qa_assignee) {

    	es.putMapping(TestTicketSumary.class);
    	
		suffix.setValue("sum_201814");
		
//		TestTicketSumary summary = 
//				new TestTicketSumaryBuilder()
//					.setJiraId(jiraId)
//					.setType(type)
//					.setComponent(component)
//					.setLabel(label)
//					.setStatus(status)
//					.setBa_assignee(ba_assignee)
//					.setDev_assignee(dev_assignee)
//					.setQa_assignee(qa_assignee)
//					.build();
		
		TestTicketSumary summary = 
				new TestTicketSumaryBuilder()
					.setJiraId("ggtest")
					.setType("ERE11")
					.setComponent("ERE11")
					.setLabel("ERE")
					.setStatus("ERE")
					.setBa_assignee("ERE")
					.setDev_assignee("ERE")
					.setQa_assignee("ERE")
					.build();
		
		testTicketSumaryService.save(summary);
		
		return new ResponseEntity<String>("POST Response", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> get() {
		suffix.setValue("sum_201809");
		
        Iterable<TestTicketSumary> tickets = testTicketSumaryService.findAll();
        tickets.forEach(x -> System.out.println(x));
        
	    return new ResponseEntity<String>("GET Response", HttpStatus.OK);
	}
}