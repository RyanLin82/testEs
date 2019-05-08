package org.cmsideproject.component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.cmsideproject.exception.ErrorInputException;
import org.cmsideproject.log.MinervaLog;
import org.cmsideproject.log.MinervaLogImp;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
import org.elasticsearch.client.transport.TransportClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AliasSetting {

	private MinervaLog log = new MinervaLogImp(this.getClass());

	private final String indexNamePattern = "test_ryan_";

	private final String aliasPattern = "ryan_";
	@Autowired
	TransportClient client;

	/**
	 * Set index's alias
	 * 
	 * @param indexName
	 * @param aliasName
	 * @throws IOException
	 * @throws ErrorInputException
	 */
	public void setAlias(String indexName, String aliasName) throws IOException, ErrorInputException {

		if (StringUtils.isEmpty(indexName) || StringUtils.isEmpty(aliasName)) {
			throw new ErrorInputException("Alias setting miss indexName or aliasName");
		}

		client.admin().indices().prepareAliases().addAlias(indexName, aliasName).execute();
		log.info("IndexName", indexName, "aliasName", aliasName);
	}

	/**
	 * Set list of indices' alias.
	 * 
	 * @param indexName
	 * @param aliasName
	 * @throws IOException
	 * @throws ErrorInputException
	 */
	public void setAlias(List<String> indexName, String aliasName) throws IOException, ErrorInputException {

		if (indexName == null || indexName.size() != 0 || StringUtils.isEmpty(aliasName)) {
			throw new ErrorInputException("Alias setting miss indexName or aliasName");
		}
		client.admin().indices().prepareAliases().addAlias(indexName.toArray(new String[0]), aliasName).execute();
		log.info("IndexName", indexName.toString(), "aliasName", aliasName);
	}

	/**
	 * Set data's alias
	 * 
	 * @param data
	 * @throws ParseException
	 * @throws ErrorInputException
	 */
	public void setAlias(TicketSummarySpringDataDTO data) throws ParseException, ErrorInputException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyyMM");
		DateFormat df3 = new SimpleDateFormat("yyyy");

		if (StringUtils.isEmpty(data.getJira()) || StringUtils.isEmpty(data.getDoneDate())) {
			throw new ErrorInputException("Alias setting miss ticketNumber or doneDate");
		}

		String index = indexNamePattern + df2.format(df.parse(data.getDoneDate())).toLowerCase();
		String alias = aliasPattern + df3.format(df2.format(df.parse(data.getDoneDate())));

		AliasActions action = new AliasActions(AliasActions.Type.ADD).index(index).alias(alias);

		client.admin().indices().prepareAliases().addAliasAction(action).execute();

		log.info("index", index, "alias", alias, data);
	}

	/**
	 * Set data's alias.
	 * 
	 * @param data
	 * @throws ParseException
	 * @throws ErrorInputException
	 */
	public void setAlias(List<Map<String, Object>> data) throws ParseException, ErrorInputException {

		List<TicketSummarySpringDataDTO> datalist = this.listMapToListObject(data);
		if (data == null || data.size() == 0) {
			throw new ErrorInputException("Alias setting miss ticket Information");
		}
		for (TicketSummarySpringDataDTO dto : datalist) {
			this.setAlias(dto);
		}
	}

	/**
	 * list map to list object
	 * 
	 * @param dataList
	 * @return
	 */
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
