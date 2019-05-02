package org.cmsideproject.miverva.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

	@Override
	public void save(List<Map<String, Object>> datas) throws ErrorInputException, ParseException, IOException {
		List<TicketSummarySpringDataDTO> datalist = null;
		datalist = this.listMapToListObject(datas);
		List<String> indices = new ArrayList<>();
		for (TicketSummarySpringDataDTO data : datalist) {
			String indexName = "test_ryan_" + this.getIndex(data);
			setIndex(data);
			ticketRepository.save(data);
			indices.add(indexName);
			log.info(indexName, "update", data);
		}
	}

	@Override
	public Optional<List<TicketSummarySpringDataDTO>> findByJira(String id) {
		return ticketRepository.findByJira(id);
	}

	@Override
	public List getByDate(String fromDate, String thrDate)
			throws InterruptedException, ExecutionException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date fr = sdf.parse(fromDate);
		Date thr = sdf.parse(thrDate);
		Calendar start = new GregorianCalendar();
		start.setTime(fr);
		Calendar end = Calendar.getInstance();
		end.setTime(thr);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMM");

		List list = new ArrayList<>();

		for (Date temp = start.getTime(); start.before(end); start.add(Calendar.MONTH, 1), temp = start.getTime()) {
			System.out.println("ryan_" + sdf2.format(temp));

			list.add(this.getByAlias("ryan_" + sdf2.format(temp)));
		}

		return list;

	}

	@Override
	public List<TicketSummarySpringDataDTO> getByAlias(String aliasName)
			throws InterruptedException, ExecutionException {
		GetAliasesResponse r = client.admin().indices().getAliases(new GetAliasesRequest().aliases(aliasName)).get();

		List list = new ArrayList<>();
		for (Iterator<String> it = r.getAliases().keysIt(); it.hasNext();) {
			// HERE IS THE REALINDEXNAME
			String realIndexName = it.next();
			suffix.setValue(realIndexName.replaceFirst("test_ryan_", ""));
			list.add(ticketRepository.findAll());
		}
		return list;
	}

	@Override
	public void delete(List<Map<String, Object>> tickets) {

		List<TicketSummarySpringDataDTO> ticketList = this.listMapToListObject(tickets);

		for (TicketSummarySpringDataDTO ticket : ticketList) {
			ticketRepository.delete(ticket);
		}
	}

	private void setIndex(TicketSummarySpringDataDTO data) throws ParseException {

		suffix.setValue(this.getIndex(data).toLowerCase());

	}

	private String getIndex(TicketSummarySpringDataDTO data) {

		return data.getJira();
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
}