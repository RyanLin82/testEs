package org.cmsideproject.minerva.service;

import java.io.IOException;
import java.text.DateFormat;
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
import java.util.concurrent.ExecutionException;

import org.apache.commons.lang3.StringUtils;
import org.cmsideproject.component.AliasSetting;
import org.cmsideproject.component.TicketIndicesAlias;
import org.cmsideproject.config.Suffix;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.log.MinervaLogImp;
import org.cmsideproject.minerva.entity.TicketSummary;
import org.cmsideproject.minerva.repo.SummaryRepository;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketSumaryServiceImpl implements TicketSumaryService {

	MinervaLogImp log = new MinervaLogImp(this.getClass());

	@Autowired
	private SummaryRepository ticketRepository;

	@Autowired
	TransportClient client;

	@Autowired
	private Suffix suffix;
	
	@Autowired
	AliasSetting aliasSetting;

	@Autowired
	private TicketIndicesAlias ticketIndices;

	@Autowired
	public void setTicketRepository(SummaryRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	
	@Override
	public void save(List<Map<String, Object>> data) throws ErrorInputException, ParseException, IOException {
		List<TicketSummary> datalist = new ArrayList<>();
		datalist = this.listMapToListObject(data);
		this.saveByEntity(datalist);
	}

	public void saveByEntity(List<TicketSummary> data)
			throws ErrorInputException, ParseException, IOException {
		data = this.removeDuplicateDataInEs(data);
		List<String> indices = new ArrayList<>();
		for (TicketSummary ticket : data) {
			String indexName = "test_ryan_" + this.getIndex(ticket);
//			setIndex(ticket);
			this.setIndexByMonth(ticket);
			ticketRepository.save(ticket);
			indices.add(indexName);
			log.info(indexName, "update", ticket);
		}
		
	}

	@Override
	public Optional<List<TicketSummary>> findByJira(String id) {
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
	public List<TicketSummary> getByAlias(String aliasName)
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

		List<TicketSummary> ticketList = this.listMapToListObject(tickets);

		for (TicketSummary ticket : ticketList) {
			ticketRepository.delete(ticket);
		}
	}

	private String setIndexByMonth(TicketSummary data) throws ErrorInputException, ParseException {

		if (StringUtils.isEmpty(data.getJira()) || StringUtils.isEmpty(data.getDoneDate())) {
			throw new ErrorInputException("Alias setting miss ticketNumber or doneDate");
		}

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyyMM");

		String indexName = df2.format(df.parse(data.getDoneDate())).toLowerCase();
		suffix.setValue(indexName);
		return indexName;

	}

	private void setIndex(TicketSummary data) throws ParseException {

		suffix.setValue(data.getJira().toLowerCase());

	}

	private String getIndex(TicketSummary data) {

		return data.getJira();
	}

	private List<TicketSummary> listMapToListObject(List<Map<String, Object>> dataList) {

		List<TicketSummary> resultList = new ArrayList<>();
		ModelMapper mapper2 = new ModelMapper();
		for (Map<String, Object> map : dataList) {
			TicketSummary ticket = mapper2.map(map, TicketSummary.class);
			resultList.add(ticket);
		}
		return resultList;
	}

	private List<TicketSummary> removeDuplicateDataInEs(List<TicketSummary> data) {
		List<TicketSummary> returnData = new ArrayList<>();
		for (TicketSummary ticket : data) {
			if (ticketIndices.hasDocument(ticket.getJira())) {
				continue;
			}
			returnData.add(ticket);
		}
		return returnData;
	}

}