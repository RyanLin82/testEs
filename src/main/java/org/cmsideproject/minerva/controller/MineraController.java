package org.cmsideproject.minerva.controller;

import java.util.List;

import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.cmsideproject.minerva.repo.TicketSumaryRepo;
import org.cmsideproject.miverva.service.JiraTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${minerva.api}")
public class MineraController {

	// private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	JiraTicketService jiraTicketService;

	/**
	 * Insert datas into certain index.
	 * 
	 * @param index
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "minerva/add/{index}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse postIndex(@PathVariable("index") String index, @RequestBody String data) {

		String msg = "";
		String status = "";
		List<TicketSumaryDTO> reponse = null;
		try {
			jiraTicketService.add(index, data);
			msg = "success";
			status = "1";
		} catch (Exception e) {
			msg = "error";
			status = "666";
		}
		MinervaResponse resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatus(status)
				.build();

		return resJson;

	}

//	@RequestMapping(value = "get/all/{index}", method = RequestMethod.POST)
//	public MinervaResponse getAll(@PathVariable("index") String index, @RequestBody String data) {
//		String msg = "";
//		String status = "";
//		List<TicketSumaryDTO> reponse = null;
//		try {
//			reponse = (List<TicketSumaryDTO>) jiraTicketService.getAll(index, data, true);
//			msg = "success";
//			status = "1";
//		} catch (DTOParseFailException e) {
//			status = e.getCode();
//			msg = e.getMessage();
//		} catch (Exception e) {
//			msg = "error";
//			status = "666";
//		}
//		MinervaResponse resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatus(status)
//				.setData(reponse).build();
//		return resJson;
//
//	}

	/**
	 * Get 1000 datas from certain index.
	 * 
	 * @param index
	 * @return if there is data in certain index then return data value; otherwise
	 *         return empty arraylist.
	 * @throws ElasticSearchRequestException
	 */
	@RequestMapping(value = "get/{index}", method = RequestMethod.GET)
	public MinervaResponse getAllByIndex(@PathVariable("index") String index) {
		String msg = "";
		String status = "";
		List<TicketSumaryDTO> reponse = null;
		try {
			reponse = (List<TicketSumaryDTO>) jiraTicketService.getAll(index);
			msg = "success";
			status = "1";
		} catch (ElasticSearchRequestException e) {
			status = e.getCode();
			msg = e.getMessage();
		} catch (DTOParseFailException e) {
			status = e.getCode();
			msg = e.getMessage();
		} catch (Exception e) {
			msg = "error";
			status = "666";
			System.out.println(e.getStackTrace());
			System.out.println(e);
		}
		MinervaResponse resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatus(status)
				.setData(reponse).build();
		return resJson;

	}

//	/**
//	 * Insert datas into certain index.
//	 * 
//	 * @param index
//	 * @param data
//	 * @return
//	 */
//	@RequestMapping(value = "update/{index}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	public MinervaResponse updateDataByJiraNum(@PathVariable("index") String indexName, @RequestBody String data,
//			@RequestParam(value = "jiraNum") String jiraNum) {
//
//		// ticketSumaryService.update(indexName, data, jiraNum);
//		String msg = "";
//		String status = "";
//		List<TicketSumaryDTO> reponse = null;
//		try {
//			jiraTicketService.update(indexName, data, jiraNum);
//			msg = "success";
//			status = "1";
//		} catch (DTOParseFailException e) {
//			status = e.getCode();
//			msg = e.getMessage();
//		} catch (Exception e) {
//			msg = "error";
//			status = "666";
//		}
//		MinervaResponse resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatus(status)
//				.build();
//		return resJson;
//
//	}

//	/**
//	 * Insert datas into certain index.
//	 * 
//	 * @param index
//	 * @param data
//	 * @return
//	 */
//	@RequestMapping(value = "delete/{index}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//	public MinervaResponse delete(@PathVariable("index") String index, @RequestBody String conditions) {
//
//		String msg = "";
//		String status = "";
//		List<TicketSumaryDTO> reponse = null;
//		try {
//			jiraTicketService.delete(index, conditions);
//			msg = "success";
//			status = "1";
//		} catch (Exception e) {
//			msg = "error";
//			status = "666";
//		}
//		MinervaResponse resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatus(status)
//				.build();
//		return resJson;
//
//	}
}
