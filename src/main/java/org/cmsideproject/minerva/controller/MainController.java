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
import java.util.concurrent.ExecutionException;

import org.cmsideproject.component.AliasSetting;
import org.cmsideproject.config.Suffix;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.SearchDate;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.cmsideproject.miverva.service.TestTicketSumaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/minerva")
public class MainController {

	@Autowired
	private TestTicketSumaryService testTicketSumaryService;

	@Autowired
	private Suffix suffix;

	@Autowired
	AliasSetting aliasSetting;

//	@RequestMapping(value = "minerva/TicketSummary/insertOne", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	public MinervaResponse insertOne(@RequestParam String index, @RequestBody TicketSummarySpringDataDTO data)
//			throws ErrorInputException, ParseException, IOException {
//		MinervaResponse minervaResponse = new MinervaResponse();
//		testTicketSumaryService.saveByDto(data);
//		aliasSetting.setAlias(data);
//		return minervaResponse;
//	}
	
	@RequestMapping(value = "minerva/TicketSummary/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse insert(@RequestBody List<Map<String, Object>> data)
			throws ErrorInputException, ParseException, IOException {
		
		MinervaResponse minervaResponse = new MinervaResponse();
		List<TicketSummarySpringDataDTO> dataList = this.listMapToListObject(data);
		testTicketSumaryService.save(data);
		aliasSetting.setAlias(dataList);
		return minervaResponse;
	}

	@RequestMapping(value = "minerva/TicketSummary/getOne", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse getOne(@RequestParam String fromDate, @RequestParam String thrDate,
			@RequestBody String ticketNumber) throws ParseException {
		this.setDate(fromDate, thrDate);
		MinervaResponse minervaResponse = new MinervaResponse();
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
	public MinervaResponse getAllByTicketNumber(@RequestParam String index)
			throws ErrorInputException {
		suffix.setValue(index.toLowerCase());
		MinervaResponse minervaResponse = new MinervaResponse();
		List list = new ArrayList<>();
		list.add(testTicketSumaryService.findById(index).get());
		minervaResponse.setData(list);
		return minervaResponse;
	}

	@RequestMapping(value = "minerva/TicketSummary/getByAlias", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse getByAlias(@RequestParam String alias) throws InterruptedException, ExecutionException {
		MinervaResponse minervaResponse = new MinervaResponse();
		List list = new ArrayList<>();
		list.add(testTicketSumaryService.getByAlias(alias));
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

	private List<TicketSummarySpringDataDTO> listMapToListObject(List<Map<String, Object>> dataList) {

		List<TicketSummarySpringDataDTO> resultList = new ArrayList<>();
		ModelMapper mapper2 = new ModelMapper();
		for (Map<String, Object> map : dataList) {
			TicketSummarySpringDataDTO ticket = mapper2.map(map, TicketSummarySpringDataDTO.class);
			resultList.add(ticket);
		}
		return resultList;
	}
	
}