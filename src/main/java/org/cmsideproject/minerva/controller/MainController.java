package org.cmsideproject.minerva.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.cmsideproject.Suffix;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.GetResponse;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.miverva.service.TestTicketSumaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public MinervaResponse postTicketSumary(@RequestParam String index, @RequestBody List<Map<String, Object>> data)
			throws ErrorInputException, ParseException {
//		suffix.setValue(index);
		MinervaResponse minervaResponse = new MinervaResponse();
		testTicketSumaryService.save(data);
		return minervaResponse;
	}

	@RequestMapping(value = "minerva/TicketSummary/getOne", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public GetResponse getOne(@RequestParam String fromDate, @RequestParam String thrDate,
			@RequestBody String ticketNumber) throws ParseException {
//		suffix.setValue(index);
		this.setDate(fromDate, thrDate);
		GetResponse minervaResponse = new GetResponse();
		List list = new ArrayList<>();
		String index;
		for(int i = searchDate.singleton.getFromYear(); i < searchDate.singleton.getThrYear(); i++) {
			for(int j = searchDate.singleton.getFromMonth(); j < searchDate.singleton.getThrMonth(); j++) {
				index = Integer.toString(i) + Integer.toString(j);
				suffix.setValue(index);
				try {
				list.add(testTicketSumaryService.findById(ticketNumber).get());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		minervaResponse.setData(list);
		return minervaResponse;
	}

	@RequestMapping(value = "minerva/TicketSummary/getAll", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public GetResponse getAllByTicketNumber(@RequestParam String index, @RequestBody String ticketNumber)
			throws ErrorInputException {
		suffix.setValue(index);
		GetResponse minervaResponse = new GetResponse();
		List list = new ArrayList<>();
		list.add(testTicketSumaryService.findByJira(ticketNumber).get());
		minervaResponse.setData(list);
		return minervaResponse;
	}

	private void setDate(String fromDate, String thrDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date frDate = sdf.parse(fromDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(frDate);
		int fromYear = calendar.get(Calendar.YEAR);
		int fromMonth = calendar.get(Calendar.MONTH);

		Date thDate = sdf.parse(thrDate);
		calendar.setTime(thDate);
		int thrYear = calendar.get(Calendar.YEAR);
		int thrMonth = calendar.get(Calendar.MONTH);
		new searchDate.builder().setFromMonth(fromMonth).setFromYear(fromYear).setThrMonth(thrMonth).setThrYear(thrYear)
				.build();
	}

	private static class searchDate {

		private static searchDate singleton;
		
		private int fromYear;
		private int fromMonth;

		private int thrYear;
		private int thrMonth;

		public searchDate(builder builder) {
			
			this.fromMonth = builder.fromMonth;
			this.fromYear = builder.fromYear;
			this.thrMonth = builder.thrMonth;
			this.thrYear = builder.thrYear;
			singleton = this;
		}

		public int getFromYear() {
			return fromYear;
		}

		public void setFromYear(int fromYear) {
			this.fromYear = fromYear;
		}

		public int getFromMonth() {
			return fromMonth;
		}

		public void setFromMonth(int fromMonth) {
			this.fromMonth = fromMonth;
		}

		public int getThrYear() {
			return thrYear;
		}

		public void setThrYear(int thrYear) {
			this.thrYear = thrYear;
		}

		public int getThrMonth() {
			return thrMonth;
		}

		public void setThrMonth(int thrMonth) {
			this.thrMonth = thrMonth;
		}

		public static class builder {
			private int fromYear;
			private int fromMonth;

			private int thrYear;
			private int thrMonth;

			public builder setFromYear(int fromYear) {
				this.fromYear = fromYear;
				return this;
			}

			public builder setFromMonth(int fromMonth) {
				this.fromMonth = fromMonth;
				return this;
			}

			public builder setThrYear(int thrYear) {
				this.thrYear = thrYear;
				return this;
			}

			public builder setThrMonth(int thrMonth) {
				this.thrMonth = thrMonth;
				return this;
			}

			public searchDate build() {
				return new searchDate(this);
			}

		}

	}
}