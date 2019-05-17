package org.cmsideproject.component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class TicketIndicesAlias {

	@Autowired
	ClusterHealthResponse response;

	@Autowired
	TransportClient client;

	@Autowired
	RestHighLevelClient restClient;

	private final String indicesPattern = "RYAN";

	public Map<String, Set<AliasMetaData>> aliasIndicesMapping;

	private Set<String> indicesName;

	private Map<String, Set<String>> indexTicketNumMapping;

	private Set<String> aliasName;

	@PostConstruct
	private void init() throws IOException {
		this.refreshData();
	}

	/**
	 * Refresh data.
	 * 
	 * @throws IOException
	 */
	public void refreshData() throws IOException {
		setIndices();
		setAliasMappingIndex();
		setAlias();
		setIndexTicketNumMapping();
	}

	/**
	 * Check whether input index name exists.
	 * 
	 * @param indexName
	 * @return true if there is the same index in elasticsearch.
	 */
	public boolean hasIndices(String... indexName) {
		return indicesName.contains(indexName);
	}

	/**
	 * Check whether input index name exists.
	 * 
	 * @param indicesName
	 * @return true if there is the same index in elasticsearch.
	 */
	public boolean hasIndices(List<String> indicesName) {
		return indicesName.contains(indicesName);
	}

	public boolean hasDocument(String id) {
		if (indexTicketNumMapping == null || indexTicketNumMapping.isEmpty()) {
			return false;
		}
		for (Map.Entry<String, Set<String>> entry : indexTicketNumMapping.entrySet()) {
			for (String documentId : entry.getValue()) {
				if (StringUtils.equals(documentId.toUpperCase(), id.toUpperCase())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get aliasIndicesMapping.
	 * 
	 * @return if aliasIndicesMapping is not null then return Map<String,
	 *         Set<AliasMetaData>>; otherwise return empty Hashmap
	 */
	@Cacheable("test4")
	public Map<String, Set<AliasMetaData>> getAliasIndicesMapping() {
		DateFormat sdf = new SimpleDateFormat("MM/dd hhmmss");
		System.out.println("getAliasIndicesMapping === " + sdf.format(Calendar.getInstance().getTime()));
		return aliasIndicesMapping == null ? new HashMap<>() : aliasIndicesMapping;
	}

	/**
	 * Get aliasName.
	 * 
	 * @return if aliasName is not null then return Set<String>; otherwise return
	 *         empty HashSet.
	 */
	@Cacheable("test")
	public Set<String> getAlias() {
		DateFormat sdf = new SimpleDateFormat("MM/dd hhmmss");
		System.out.println("getAlias === " + sdf.format(Calendar.getInstance().getTime()));
		return aliasName == null ? new HashSet<>() : aliasName;
	}

	/**
	 * Get indicesName.
	 * 
	 * @return if indicesName is not null then return Set<String>; otherwise return
	 *         empty HashSet.
	 */
	@Cacheable("test2")
	public Set<String> getIndicesName() {
		DateFormat sdf = new SimpleDateFormat("MM/dd hhmmss");
		System.out.println("getIndicesName === " + sdf.format(Calendar.getInstance().getTime()));
		return indicesName == null ? new HashSet<>() : indicesName;
	}

	/**
	 * Get indexTicketNumMapping.
	 * 
	 * @return if indexTicketNumMapping is not null then return Map<String,
	 *         Set<String>>; otherwise return empty HashSet.
	 */
	@Cacheable("test3")
	public Map<String, Set<String>> getIndexTicketNumMapping() {
		DateFormat sdf = new SimpleDateFormat("MM/dd hhmmss");
		System.out.println("getIndexTicketNumMapping === " + sdf.format(Calendar.getInstance().getTime()));
		return indexTicketNumMapping == null ? new HashMap<>() : indexTicketNumMapping;
	}

	/**
	 * Set map of string indicesName. Get indices list from elasticsearch.
	 * 
	 * @throws IOException
	 */
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
		for (String alias : aliasIndicesMapping.keySet()) {
			aliasName.add(alias);
		}
	}

	/**
	 * Set index and document mapping. e.g. ("sum_201801", "CZ-00001")
	 * 
	 * @throws IOException
	 */
	private void setIndexTicketNumMapping() throws IOException {

		SearchRequest searchRequest = new SearchRequest();
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchQuery("jira", "CZ-.*"));
		searchRequest.source(searchSourceBuilder);

		SearchResponse searchResponse = restClient.search(searchRequest, RequestOptions.DEFAULT);
		Map<String, Set<String>> indexTicketNumMap = new HashMap<>();
		SearchHit[] hits = searchResponse.getHits().getHits();
		for (SearchHit hit : hits) {
			if (indexTicketNumMap.get(hit.getIndex()) == null || indexTicketNumMap.get(hit.getIndex()).size() == 0) {
				Set<String> ticketNum = new HashSet<>();
				ticketNum.add(hit.getId());
				indexTicketNumMap.put(hit.getIndex(), ticketNum);
				continue;
			}
			indexTicketNumMap.get(hit.getIndex()).add(hit.getId());
		}
		indexTicketNumMapping = indexTicketNumMap;
	}

	/**
	 * Set alias indices mapping.
	 * 
	 * @throws IOException
	 */
	private void setAliasMappingIndex() throws IOException {

		GetAliasesRequest request = new GetAliasesRequest();

		List<String> indicesList = new ArrayList<>();
		for (String indexName : indicesName) {
			if (StringUtils.containsAny(indicesPattern, indexName.toUpperCase())) {
				indicesList.add(indexName);
			}
		}
		request.indices(indicesList.toArray(new String[0]));
		GetAliasesResponse response = restClient.indices().getAlias(request, RequestOptions.DEFAULT);
		aliasIndicesMapping = response.getAliases();

	}
}
