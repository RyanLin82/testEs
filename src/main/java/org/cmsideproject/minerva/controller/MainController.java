package org.cmsideproject.minerva.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.cmsideproject.component.AliasSetting;
import org.cmsideproject.component.TicketIndices;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.cmsideproject.minerva.service.TestTicketSumaryService;
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
	AliasSetting aliasSetting;

	@Autowired
	TicketIndices ticketIndices;

	/**
	 * Insert ticket information.
	 * 
	 * @param data
	 * @return
	 * @throws ErrorInputException
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value = "TicketSummary/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse add(@RequestBody List<Map<String, Object>> data)
			throws ErrorInputException, ParseException, IOException {

		MinervaResponse minervaResponse = new MinervaResponse();
		testTicketSumaryService.save(data);
		System.out.println("mokito testttt");
		return minervaResponse;
	}

	/**
	 * Find the ticket information by fromDate and thrDate
	 * 
	 * @param fromDate
	 * @param thrDate
	 * @return
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@RequestMapping(value = "TicketSummary/findByDate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse findByDate(@RequestParam String fromDate, @RequestParam String thrDate)
			throws ParseException, InterruptedException, ExecutionException {
		System.out.println("tttttttttttt");
		MinervaResponse minervaResponse = new MinervaResponse();
		minervaResponse.setData(testTicketSumaryService.getByDate(fromDate, thrDate));
		return minervaResponse;
	}

	/**
	 * Find the ticket information by ticketNumber
	 * 
	 * @param ticketNumber
	 * @return
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@RequestMapping(value = "TicketSummary/findByTicketNumber", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse findByTicketNumber(@RequestParam String ticketNumber) {
		System.out.println(ticketNumber);
		MinervaResponse minervaResponse = new MinervaResponse();
		System.out.println("mokito testttt2");
		minervaResponse.setData(testTicketSumaryService.findByJira(ticketNumber).get());
		return minervaResponse;
	}

	/**
	 * Update the ticket information
	 * 
	 * @param data
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws ErrorInputException
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping(value = "TicketSummary/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse update(@RequestBody List<Map<String, Object>> data)
			throws ErrorInputException, ParseException, IOException {
		MinervaResponse minervaResponse = new MinervaResponse();
		testTicketSumaryService.save(data);
		return minervaResponse;
	}

	@RequestMapping(value = "TicketSummary/setAlias", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse setAlias(@RequestParam String aliasName, @RequestParam String indexName)
			throws ErrorInputException, IOException {
		MinervaResponse minervaResponse = new MinervaResponse();
		aliasSetting.setAlias(indexName, aliasName);
		return minervaResponse;
	}

	/**
	 * Delete the ticket information.
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "TicketSummary/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse delete(@RequestBody List<Map<String, Object>> data) {
		MinervaResponse minervaResponse = new MinervaResponse();
		testTicketSumaryService.delete(data);
		return minervaResponse;
	}
}