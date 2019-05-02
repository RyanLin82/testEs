package org.cmsideproject.component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.cmsideproject.log.MinervaLog;
import org.cmsideproject.log.MinervaLogImp;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
import org.elasticsearch.client.transport.TransportClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AliasSetting {

	private MinervaLog log = new MinervaLogImp(this.getClass());

	@Autowired
	TransportClient client;

	public void setAlias(String indexName, String aliasName) throws IOException {

		if(StringUtils.isEmpty(indexName) || StringUtils.isEmpty(aliasName)) {
			return;
		}
		
		client.admin().indices().prepareAliases().addAlias(indexName, aliasName).execute();
		log.info("IndexName", indexName, "aliasName", aliasName);
	}

	public void setAlias(List<String> indexName, String aliasName) throws IOException {

		if(indexName == null || indexName.size() !=0 || StringUtils.isEmpty(aliasName)) {
			return;
		}
		client.admin().indices().prepareAliases().addAlias(indexName.toArray(new String[0]), aliasName).execute();
		log.info("IndexName", indexName.toString(), "aliasName", aliasName);
	}

	public void setAlias(TicketSummarySpringDataDTO data) throws ParseException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyyMM");

		String index = "test_ryan_" + data.getJira().toLowerCase();
		String alias = "ryan_" + df2.format(df.parse(data.getDoneDate()));

		AliasActions action = new AliasActions(AliasActions.Type.ADD).index(index).alias(alias);

		client.admin().indices().prepareAliases().addAliasAction(action).execute();
		
		log.info("index", index, "alias", alias, data);
	}

	public void setAlias(List<Map<String, Object>> data) throws ParseException {

		List<TicketSummarySpringDataDTO> datalist = this.listMapToListObject(data);
		if(data == null || data.size() == 0) {
			return;
		}
		for(TicketSummarySpringDataDTO dto : datalist) {
			this.setAlias(dto);	
		}
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
