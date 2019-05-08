package org.cmsideproject.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.cmsideproject.minerva.repo.TestTicketSummaryRepository;
import org.cmsideproject.minerva.service.TestTicketSumaryServiceImpl;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketIndices {

	@Autowired
	ClusterHealthResponse response;
	
	@Autowired
	TransportClient client;
	
	@Autowired
	RestHighLevelClient restClient;
	
	@Autowired
	TestTicketSummaryRepository testTicketSummaryRepository;

	private final String indicesPattern = "RYAN";

	public Map<String, Set<AliasMetaData>> aliasIndicesMapping;
	
	private Set<String> indicesName;
	
	private Map<String, Set<String>> indexTicketNumMapping;
	
	private Set<String> aliasName;
	
	private void setIndices() throws IOException {
		Set<String> value = response.getIndices().keySet();
		Set<String> indices = new HashSet<>();
		for (String index : value) {
			if (StringUtils.contains(index.toUpperCase(), indicesPattern)) {
				indices.add(index);
			}
		}
		indicesName = indices;
	}

	private void setAlias() {
		aliasName = new HashSet<>();
		for(String alias : aliasIndicesMapping.keySet()) {
			aliasName.add(alias);
		}
	}
	
	private void indexTicketNumMapping() throws IOException {

		SearchRequest searchRequest = new SearchRequest(); 
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
		searchSourceBuilder.query(QueryBuilders.matchQuery("jira", "CZ-.*")); 
		searchRequest.source(searchSourceBuilder);
		
		
		SearchResponse searchResponse = restClient.search(searchRequest, RequestOptions.DEFAULT);
		Map<String, Set<String>> indexTicketNumMap = new HashMap<>();
		String scrollId = searchResponse.getScrollId(); 
		SearchHit[] hits = searchResponse.getHits().getHits();
		for(SearchHit hit : hits) {
			if(indexTicketNumMap.get(hit.getIndex()) == null || indexTicketNumMap.get(hit.getIndex()).size() == 0) {
				Set<String> ticketNum = new HashSet<>();
				ticketNum.add(hit.getId());
				indexTicketNumMap.put(hit.getIndex(), ticketNum);
				continue;
			}
			indexTicketNumMap.get(hit.getIndex()).add(hit.getId());
			System.out.print(hit.getId());
		}
		indexTicketNumMapping = indexTicketNumMap;
//		response.getId();
	}	
	private void setAliasMappingIndex() throws IOException {
		
		GetAliasesRequest request = new GetAliasesRequest();
		
		List<String> indicesList = new ArrayList<>();
		for(String indexName : indicesName) {
			 if(StringUtils.containsAny("ryan", indexName)) {
				 indicesList.add(indexName);
			 }
		}
		request.indices(indicesList.toArray(new String[0]));
		GetAliasesResponse response = restClient.indices().getAlias(request, RequestOptions.DEFAULT);
		aliasIndicesMapping = response.getAliases();
		
	}
	
	public Map<String, Set<AliasMetaData>> getAliasIndicesMapping(){
		return aliasIndicesMapping == null ? new HashMap<>() : aliasIndicesMapping;
	}
	
	public Set<String> getAlias(){
		return aliasName == null ? new HashSet<>() : aliasName;
	}
	
	public Set<String> getIndicesName() {
		return indicesName == null ? new HashSet<>() : indicesName;
	}
	
	@PostConstruct
	private void init() throws IOException {
			this.refreshData();
	}

	public void refreshData() throws IOException {
		setIndices();
		setAliasMappingIndex();
		setAlias();
		indexTicketNumMapping();
	}
	
	/**
	 * Check whether input index name exists.
	 * @param indexName
	 * @return true if there is the same 
	 */
	public boolean existIndices(String... indexName) {
		return indicesName.contains(indexName);
	}
	
	public boolean existIndices(List<String> indicesName) {
		return indicesName.contains(indicesName);
	}
}
