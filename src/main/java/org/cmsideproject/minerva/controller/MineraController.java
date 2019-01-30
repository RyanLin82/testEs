package org.cmsideproject.minerva.controller;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.MinervaResponseStatus;
import org.cmsideproject.minerva.entity.TicketSumaryDTO;
import org.cmsideproject.miverva.service.JiraTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("${minerva.api}")
public class MineraController {

	private Logger log = LogManager.getLogger(this.getClass());

	@Autowired
	JiraTicketService jiraTicketService;

	/**
	 * Insert datas into certain index.
	 * 
	 * @param index
	 * @param data
	 * @return
	 * @throws ElasticSearchRequestException
	 * @throws ErrorInputException
	 */
	@RequestMapping(value = "minerva/post/{index}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public MinervaResponse postTicketSumary(@PathVariable("index") String index, @RequestBody String data) {

		String msg = "";
		String statusCode = "";
		MinervaResponseStatus status = null;
		List<TicketSumaryDTO> reponse = null;
		try {
			jiraTicketService.add(index, data);
			statusCode = "100";
			status = MinervaResponseStatus.success;
			msg = "success";
		} catch (ErrorInputException | ElasticSearchRequestException e) {
			statusCode = e.getCode();
			msg = e.getMessage();
			status = MinervaResponseStatus.fail;
			log.info("" + e);
			e.printStackTrace();
		} finally {
			if (status == null) {
				status = MinervaResponseStatus.error;
			}
			log.info("\n GetAll data from \n Index : [{}] \n status : [{}] \n message : [{}]", index,
					status.getStatus(), msg);
		}

		MinervaResponse resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatus(status)
				.setStatusCode(statusCode).setData(reponse).build();

		return resJson;

	}

	@RequestMapping(value = "get/ticketSumary/{index}", method = RequestMethod.POST)
	public MinervaResponse get(@PathVariable("index") String index, @RequestBody String data) {
		String msg = "";
		String statusCode = "";
		MinervaResponseStatus status = null;
		List<TicketSumaryDTO> reponse = null;
		try {
			reponse = (List<TicketSumaryDTO>) jiraTicketService.get(index, data, false);
			statusCode = "100";
			status = MinervaResponseStatus.success;
			msg = "success";
		} catch (DTOParseFailException e) {
			statusCode = e.getCode();
			msg = e.getMessage();
			status = MinervaResponseStatus.fail;
			log.info("" + e.getStackTrace());
		} finally {
			if (status == null) {
				status = MinervaResponseStatus.error;
			}
			log.info("\n GetAll data from \n Index : [{}] \n status code: [{}] \n message : [{}]", index, statusCode,
					msg);
		}

		MinervaResponse resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatus(status)
				.setStatusCode(statusCode).setData(reponse).build();
		return resJson;

	}

	/**
	 * Get 1000 datas from certain index.
	 * 
	 * @param index
	 * @return if there is data in certain index then return data value; otherwise
	 *         return empty arraylist.
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws ElasticSearchRequestException
	 */
	@RequestMapping(value = "get/ticketSumarys/{index}", method = RequestMethod.GET)
	public MinervaResponse getAllByIndex(@PathVariable("index") String index)
			throws JsonParseException, JsonMappingException, IOException {
		String msg = "";
		String statusCode = "";
		MinervaResponseStatus status = null;
		List<TicketSumaryDTO> reponse = null;
		try {
			reponse = (List<TicketSumaryDTO>) jiraTicketService.getAll(index);
			statusCode = "100";
			status = MinervaResponseStatus.success;
			msg = "success";
		} catch (DTOParseFailException e) {
			statusCode = e.getCode();
			msg = e.getMessage();
			status = MinervaResponseStatus.fail;
			log.info("" + e.getStackTrace());
		} finally {
			if (status == null) {
				status = MinervaResponseStatus.error;
			}
			log.info("\n GetAll data from \n Index : [{}] \n status code: [{}] \n message : [{}]", index, statusCode,
					msg);
		}

		MinervaResponse resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage(msg).setStatus(status)
				.setStatusCode(statusCode).setData(reponse).build();
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
