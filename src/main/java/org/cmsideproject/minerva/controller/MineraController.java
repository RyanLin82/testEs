package org.cmsideproject.minerva.controller;

import java.util.List;

import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.minerva.entity.MinervaResponseMsg;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.cmsideproject.minerva.repo.TicketSumaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MineraController {

	// private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	TicketSumaryRepo ticketSumaryRepo;

	/**
	 * Insert datas into certain index.
	 * 
	 * @param index
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "minerva/post/{index}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponseMsg postIndex(@PathVariable("index") String index, @RequestBody String data) {

		String resMsg = "";
		String resCode = "";
		List<TicketSumaryDTO> reponse = null;
		try {
			ticketSumaryRepo.post(index, data);
			resMsg = "success";
			resCode = "1";
		} catch (ElasticSearchRequestException e) {
			resCode = e.getCode();
			resMsg = e.getMessage();
		} catch (DTOParseFailException e) {
			resCode = e.getCode();
			resMsg = e.getMessage();
		} catch (Exception e) {
			resMsg = "error";
			resCode = "666";
		}
		MinervaResponseMsg resJson = new MinervaResponseMsg.MinervaResponseMsgBuilder().setErrorMsg(resMsg)
				.setResponseCode(resCode).setResponseObj(reponse).build();

		return resJson;

	}

	/**
	 * Get 1000 datas from certain index.
	 * 
	 * @param index
	 * @return if there is data in certain index then return data value; otherwise
	 *         return empty arraylist.
	 * @throws ElasticSearchRequestException
	 */
	@RequestMapping(value = "minerva/get/{index}", method = RequestMethod.GET)
	public MinervaResponseMsg getAllByIndex(@PathVariable("index") String index) {
		String resMsg = "";
		String resCode = "";
		List<TicketSumaryDTO> reponse = null;
		try {
			reponse = (List<TicketSumaryDTO>) ticketSumaryRepo.getAllByIndex(index);
			resMsg = "success";
			resCode = "1";
		} catch (ElasticSearchRequestException e) {
			resCode = e.getCode();
			resMsg = e.getMessage();
		} catch (DTOParseFailException e) {
			resCode = e.getCode();
			resMsg = e.getMessage();
		} catch (Exception e) {
			resMsg = "error";
			resCode = "666";
		}
		MinervaResponseMsg resJson = new MinervaResponseMsg.MinervaResponseMsgBuilder().setErrorMsg(resMsg)
				.setResponseCode(resCode).setResponseObj(reponse).build();

		return resJson;

	}

	/**
	 * Insert datas into certain index.
	 * 
	 * @param index
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "minerva/update/{index}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponseMsg updateDataByJiraNum(@PathVariable("index") String indexName, @RequestBody String data,
			@RequestParam(value = "jiraNum") String jiraNum) {

		// ticketSumaryService.update(indexName, data, jiraNum);
		String resMsg = "";
		String resCode = "";
		List<TicketSumaryDTO> reponse = null;
		try {
			ticketSumaryRepo.update(indexName, data, jiraNum);
			resMsg = "success";
			resCode = "1";
		} catch (DTOParseFailException e) {
			resCode = e.getCode();
			resMsg = e.getMessage();
		} catch (Exception e) {
			resMsg = "error";
			resCode = "666";
		}
		MinervaResponseMsg resJson = new MinervaResponseMsg.MinervaResponseMsgBuilder().setErrorMsg(resMsg)
				.setResponseCode(resCode).setResponseObj(reponse).build();

		return resJson;

	}

	@RequestMapping(value = "minerva/get/all/{index}", method = RequestMethod.POST)
	public MinervaResponseMsg getAll(@PathVariable("index") String index, @RequestBody String data) {
		String resMsg = "";
		String resCode = "";
		List<TicketSumaryDTO> reponse = null;
		try {
			reponse = (List<TicketSumaryDTO>) ticketSumaryRepo.getAll(index, data, true);
			resMsg = "success";
			resCode = "1";
		} catch (ElasticSearchRequestException e) {
			resCode = e.getCode();
			resMsg = e.getMessage();
		} catch (DTOParseFailException e) {
			resCode = e.getCode();
			resMsg = e.getMessage();
		} catch (Exception e) {
			resMsg = "error";
			resCode = "666";
		}
		MinervaResponseMsg resJson = new MinervaResponseMsg.MinervaResponseMsgBuilder().setErrorMsg(resMsg)
				.setResponseCode(resCode).setResponseObj(reponse).build();

		return resJson;

	}
}
