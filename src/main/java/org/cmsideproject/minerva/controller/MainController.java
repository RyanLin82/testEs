package org.cmsideproject.minerva.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.cmsideproject.component.AliasSetting;
import org.cmsideproject.config.Suffix;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.GetResponse;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.SearchDate;
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
	
	@Autowired
	AliasSetting aliasSetting;

	@RequestMapping(value = "minerva/TicketSummary/post", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse postTicketSumary(@RequestParam String index, @RequestBody List<Map<String, Object>> data)
			throws ErrorInputException, ParseException, IOException {
//		suffix.setValue(index);
		MinervaResponse minervaResponse = new MinervaResponse();
//		testTicketSumaryService.save(data);
		
		
		aliasSetting.setAlias();
		
//		AliasSetting as = new AliasSetting();
//		as.setAlias();
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
		for (int i = SearchDate.singleton.getFromYear(); i < SearchDate.singleton.getThrYear(); i++) {
			for (int j = SearchDate.singleton.getFromMonth(); j < SearchDate.singleton.getThrMonth(); j++) {
				index = Integer.toString(i) + Integer.toString(j);
				suffix.setValue(index);
				try {
					list.add(testTicketSumaryService.findById(ticketNumber).get());
				} catch (Exception e) {
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
		new SearchDate.builder().setFromMonth(fromMonth).setFromYear(fromYear).setThrMonth(thrMonth).setThrYear(thrYear)
				.build();
	}

}