package org.cmsideproject.miverva.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import org.cmsideproject.config.Suffix;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.log.MinervaLogImp;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.cmsideproject.minerva.repo.TestTicketSummaryRepository;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTicketSumaryServiceImpl implements TestTicketSumaryService {

	MinervaLogImp log = new MinervaLogImp(this.getClass());

	@Autowired
	private TestTicketSummaryRepository ticketRepository;

	@Autowired
	TransportClient client;
	
	@Autowired
	private Suffix suffix;

	@Autowired
	public void setTicketRepository(TestTicketSummaryRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	public void save(List<Map<String, Object>> datas) throws ErrorInputException, ParseException, IOException {
		List<TicketSummarySpringDataDTO> datalist = null;
		datalist = this.listMapToListObject(datas);
		List<String> indices = new ArrayList<>();
		for (TicketSummarySpringDataDTO data : datalist) {
			String indexName = "test_ryan_" + this.getIndex(data);
			setIndex(data);
			ticketRepository.save(data);
			indices.add(indexName);
		}
	}
//
//	public void saveByDto(List<Map<String, Object>> dataList) throws ErrorInputException, ParseException {
//
//		for (TicketSummarySpringDataDTO data : dataList) {
//			this.saveByDto(data);
//		}
//	}

	private void setIndex(TicketSummarySpringDataDTO data) throws ParseException {

		suffix.setValue(this.getIndex(data).toLowerCase());

	}

	private String getIndex(TicketSummarySpringDataDTO data) {

		return data.getJira();
	}

	public Optional<List<TicketSummarySpringDataDTO>> findByJira(String id) {
		return ticketRepository.findByJira(id);
	}

	public Optional<TicketSummarySpringDataDTO> findById(String id) {
		return ticketRepository.findById(id);
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

	private List<Map<String, Object>> mapKeyToLowercase(List<Map<String, Object>> dataList) {

		List list = new ArrayList<>();

		for (Map<String, Object> map : dataList) {
			Map<String, Object> nodeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
			nodeMap.putAll(map);
			list.add(nodeMap);
		}
		return list;
	}

	@Override
	public List<TicketSummarySpringDataDTO> getByAlias(String aliasName) throws InterruptedException, ExecutionException {
		GetAliasesResponse r = client.admin().indices().getAliases(new GetAliasesRequest().aliases(aliasName)).get();

//		for(Iterator<String> it = r.getAliases().keysIt(); it.hasNext();) {
//			// HERE IS THE REALINDEXNAME
//			String realIndexName = it.next();
//		}
		return new ArrayList<TicketSummarySpringDataDTO>();
	
	}

//	@Override
//	public void saveByDto(Map<String, Object> data) throws ParseException {
//		setIndex(data);
//		ticketRepository.save(data);
//	}

}