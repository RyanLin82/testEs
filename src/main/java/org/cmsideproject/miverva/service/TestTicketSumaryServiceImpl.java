package org.cmsideproject.miverva.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.cmsideproject.minerva.repo.TestTicketSummaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void save(List<Map<String, Object>> datas) throws ErrorInputException {
		List<TicketSummarySpringDataDTO> datalist = null;
		datalist = this.listMapToListObject(datas);

		for (TicketSummarySpringDataDTO data : datalist) {
			ticketRepository.save(data);
		}
	}

//    public void delete(TestTicketSumary book) {
//    	ticketRepository.delete(book);
//    }
//
    public Optional<List<TicketSummarySpringDataDTO>> findByJira(String id) {
        return ticketRepository.findByJira(id);
    }
    
    public Optional<TicketSummarySpringDataDTO> findById(Long id) {
        return ticketRepository.findById(id);
    }
//
//    public Iterable<TestTicketSumary> findAll() {
//        return ticketRepository.findAll();
//    }
//    

	private List<TicketSummarySpringDataDTO> listMapToListObject(List<Map<String, Object>> dataList) {
//		dataList = this.mapKeyToLowercase(dataList);
		
		List<TicketSummarySpringDataDTO> resultList = new ArrayList<>();
		ModelMapper mapper2 = new ModelMapper();
		for (Map<String, Object> map : dataList) {
			TicketSummarySpringDataDTO ticket = mapper2.map(map, TicketSummarySpringDataDTO.class);
			resultList.add(ticket);
		}
		return resultList;
	}

	private List<Map<String, Object>> mapKeyToLowercase(List<Map<String, Object>> dataList) {

		List list = new ArrayList<>();

		for (Map<String, Object> map : dataList) {
			Map<String, Object> nodeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
			nodeMap.putAll(map);
			list.add(nodeMap);
		}
		return list;
	}

}