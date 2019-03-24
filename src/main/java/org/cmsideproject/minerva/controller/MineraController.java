package org.cmsideproject.minerva.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ElasticSearchRequestException;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.log.MinervaLog;
import org.cmsideproject.log.MinervaLogImp;
import org.cmsideproject.minerva.entity.MinervaResponse;
import org.cmsideproject.minerva.entity.PostResponse;
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

	private MinervaLog log = new MinervaLogImp(this.getClass());

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
	public MinervaResponse postTicketSumary(@PathVariable("index") String index, @RequestBody String data)
			throws ErrorInputException, ElasticSearchRequestException {
		MinervaResponse minervaResponse = new MinervaResponse();
		jiraTicketService.add(index, data);
		return minervaResponse;

	}
	
	/**
	 * Insert datas into certain index.
	 * 
	 * @param index
	 * @param data
	 * @return
	 * @throws ElasticSearchRequestException
	 * @throws ErrorInputException
	 */
	@RequestMapping(value = "minerva/{index}/addAll", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public PostResponse addtAll(@PathVariable("index") String index, @RequestBody List<Map<String,Object>> data)
			throws ErrorInputException, ElasticSearchRequestException {
		PostResponse minervaResponse = new PostResponse();
		jiraTicketService.insertAll(index, data);
		return minervaResponse;

	}

	@RequestMapping(value = "get/ticketSumary/{index}", method = RequestMethod.POST)
	public MinervaResponse get(@PathVariable("index") String index, @RequestBody String data) throws DTOParseFailException {
		MinervaResponse minervaResponse = new MinervaResponse();
		jiraTicketService.get(index, data, false);
		return minervaResponse;
	}

	/**
	 * Get 1000 datas from certain index.
	 * 
	 * @param index
	 * @return if there is data in certain index then return data value; otherwise
	 *         return empty arraylist.
	 * @throws DTOParseFailException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws ElasticSearchRequestException
	 */
	@RequestMapping(value = "get/ticketSumarys/{index}", method = RequestMethod.GET)
	public MinervaResponse getAllByIndex(@PathVariable("index") String index) throws DTOParseFailException {
		MinervaResponse minervaResponse = new MinervaResponse();
		List<TicketSumaryDTO> response = jiraTicketService.getAll(index);
		minervaResponse.setData(response);
		return minervaResponse;
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
	@RequestMapping(value = "get/ticketSumarys/111", method = RequestMethod.GET)
	public MinervaResponse test2222() {

		MinervaResponse resJson = new MinervaResponse.MinervaResponseMsgBuilder().setMessage("test2222").build();
		return resJson;

	}

	/**
	 * Get 1000 datas from certain index.
	 * 
	 * @param index
	 * @return if there is data in certain index then return data value; otherwise
	 *         return empty arraylist.
	 * @throws DTOParseFailException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws ElasticSearchRequestException
	 */
	@RequestMapping(value = "get/ticketSumarys/dto", method = RequestMethod.GET)
	public MinervaResponse testDto() throws DTOParseFailException {

		throw new DTOParseFailException("ttt", null);

	}

	/**
	 * Get 1000 datas from certain index.
	 * 
	 * @param index
	 * @return if there is data in certain index then return data value; otherwise
	 *         return empty arraylist.
	 * @throws DTOParseFailException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws ElasticSearchRequestException
	 */
	@RequestMapping(value = "get/ticketSumarys/err", method = RequestMethod.GET)
	public MinervaResponse testErrorInputException() throws ErrorInputException {

		throw new ErrorInputException("ErrorInputException", "ErrorInputException");

	}

	/**
	 * Get 1000 datas from certain index.
	 * 
	 * @param index
	 * @return if there is data in certain index then return data value; otherwise
	 *         return empty arraylist.
	 * @throws DTOParseFailException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws ElasticSearchRequestException
	 */
	@RequestMapping(value = "get/ticketSumarys/tt", method = RequestMethod.GET)
	public MinervaResponse tt() throws ErrorInputException {

		return new MinervaResponse.MinervaResponseMsgBuilder().setMessage("tt").setStatusCode("tt").build();

	}
}
