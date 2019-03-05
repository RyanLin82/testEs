package org.cmsideproject.miverva.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cmsideproject.exception.DTOParseFailException;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.cmsideproject.minerva.repo.TestTicketSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TestTicketSumaryServiceImpl implements TestTicketSumaryService {

	private TestTicketSummaryRepository ticketRepository;

	@Autowired
	public void setTicketRepository(TestTicketSummaryRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

//    public TestTicketSumary save(TestTicketSumary book) {
//        return ticketRepository.save(book);
//    }

	public void save(String datas) throws ErrorInputException {
		TicketSummarySpringDataDTO datalist = null;
		datalist = this.checkInputDataFormat(datas);

		ticketRepository.save(datalist);
	}

//    public void delete(TestTicketSumary book) {
//    	ticketRepository.delete(book);
//    }
//
//    public Optional<TestTicketSumary> findOne(String id) {
//        return ticketRepository.findById(id);
//    }
//
//    public Iterable<TestTicketSumary> findAll() {
//        return ticketRepository.findAll();
//    }
//    

	private TicketSummarySpringDataDTO checkInputDataFormat(String inputData) throws ErrorInputException {
		if (StringUtils.isEmpty(inputData)) {
			throw new ErrorInputException(inputData, "input data empty");
		}

		ObjectMapper mapper2 = new ObjectMapper();

		TicketSummarySpringDataDTO ticket2;
		try {
			ticket2 = mapper2.readValue(inputData, TicketSummarySpringDataDTO.class);
		} catch (IOException e) {
			throw new ErrorInputException(inputData, "input data mapping entity error");
		}

		return ticket2;
	}

	private List<TicketSummarySpringDataDTO> listMapToListObject(String json)
			throws JsonParseException, JsonMappingException, IOException {

//		ObjectMapper mapper = new ObjectMapper();

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class,
					TicketSummarySpringDataDTO.class));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<TicketSummarySpringDataDTO>();

//		List<Map<String, Object>> dataList = mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {
//		});
//
//		List<TicketSummarySpringDataDTO> resultList = new ArrayList<>();
//		ModelMapper mapper2 = new ModelMapper();
//		for (Map<String, Object> map : dataList) {
//			TicketSummarySpringDataDTO ticket = mapper2.map(map.get("_source"), TicketSummarySpringDataDTO.class);
//			resultList.add(ticket);
//		}
//		return items;
	}

	private Map stringToMap(String data) throws DTOParseFailException {
		ObjectMapper mopper = new ObjectMapper();
		Map<String, String> updateDataMap = new HashMap<>();
		try {
			updateDataMap = mopper.readValue(data, Map.class);
		} catch (IOException e) {
			throw new DTOParseFailException("update from " + "" + " error", e);
		}
		return updateDataMap;
	}
}