package org.cmsideproject.miverva.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.cmsideproject.component.AliasSetting;
import org.cmsideproject.config.Suffix;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.log.MinervaLogImp;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.cmsideproject.minerva.repo.TestTicketSummaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTicketSumaryServiceImpl implements TestTicketSumaryService {

	MinervaLogImp log = new MinervaLogImp(this.getClass());
	
	private TestTicketSummaryRepository ticketRepository;

	@Autowired
	private Suffix suffix;
	
	@Autowired
	AliasSetting alias;
	
	
	@Autowired
	public void setTicketRepository(TestTicketSummaryRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

//    public TestTicketSumary save(TestTicketSumary book) {
//        return ticketRepository.save(book);
//    }

	public void save(List<Map<String, Object>> datas) throws ErrorInputException, ParseException, IOException {
		List<TicketSummarySpringDataDTO> datalist = null;
		datalist = this.listMapToListObject(datas);
		String indexName; 
		for (TicketSummarySpringDataDTO data : datalist) {
			setIndex(data);
			ticketRepository.save(data);
//			indexName = this.getIndex(data);
//			alias.setAlias("sum_" + indexName.substring(0, 4),"test_ryan_" + this.getIndex(data));
//		
//			log.TicketInfo("\n\n"+ "sum" + indexName.substring(0, 3)+"\n"+"test_ryan_" + this.getIndex(data));
		
		}
		
		alias.setAlias();
	}
	
	public void saveByDto(List<TicketSummarySpringDataDTO> dataList) throws ErrorInputException, ParseException {

		for (TicketSummarySpringDataDTO data : dataList) {
			setIndex(data);
			ticketRepository.save(data);
		}
	}
	
	private void setIndex(TicketSummarySpringDataDTO data) throws ParseException {
		
		suffix.setValue(this.getIndex(data));
	
	}
	
	private String getIndex(TicketSummarySpringDataDTO data) throws ParseException {
		String doneDate = data.getDoneDate();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		Date date  = sf.parse(doneDate);
		
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int fromYear = calendar.get(Calendar.YEAR);
		int fromMonth = calendar.get(Calendar.MONTH);
		
		return Integer.toString(fromYear) + Integer.toString(fromMonth);
	}

//    public void delete(TestTicketSumary book) {
//    	ticketRepository.delete(book);
//    }
//
    public Optional<List<TicketSummarySpringDataDTO>> findByJira(String id) {
        return ticketRepository.findByJira(id);
    }
    
    public Optional<TicketSummarySpringDataDTO> findById(String id) {
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