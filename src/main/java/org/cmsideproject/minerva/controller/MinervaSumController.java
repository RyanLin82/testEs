package org.cmsideproject.minerva.controller;

import java.util.List;

import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.cmsideproject.miverva.service.JiraTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${minerva.api.template}")
public class MinervaSumController implements MinervaControllerTemplate {

	@Autowired
	JiraTicketService jiraTicketService;


	@Override
	@RequestMapping(value = "minerva/Tickets/getAll", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse getAll(@RequestBody String index) throws DTOParseFailException {
		MinervaResponse minervaResponse = new MinervaResponse();
		List<TicketSumaryDTO> response = jiraTicketService.getAll(index);
		
		minervaResponse.setData(response);
		return minervaResponse;
	}


	@Override
	@RequestMapping(value = "minerva/Tickets/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse insert(String index, String data) throws ErrorInputException, ElasticSearchRequestException {
		MinervaResponse minervaResponse = new MinervaResponse();
		jiraTicketService.insertData(index, data);;
		return minervaResponse;
	}


	@Override
	@RequestMapping(value = "minerva/Tickets/get", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse getByConditions(String index, String data) throws DTOParseFailException {
		MinervaResponse minervaResponse = new MinervaResponse();
		List<TicketSumaryDTO> response = jiraTicketService.get(index, data, false);
		minervaResponse.setData(response);
		return minervaResponse;
	}

	@Override
	@RequestMapping(value = "minerva/Tickets/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse delete(String index, String conditions) throws DTOParseFailException {
		MinervaResponse minervaResponse = new MinervaResponse();
		jiraTicketService.delete(index, conditions);;
		return minervaResponse;
	}

//	@Override
//	@RequestMapping(value = "minerva/Tickets/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	public MinervaResponse update(String index, String data) {
//		MinervaResponse minervaResponse = new MinervaResponse();
//		jiraTicketService.(index, data);;
//		return minervaResponse;
//	}


}
