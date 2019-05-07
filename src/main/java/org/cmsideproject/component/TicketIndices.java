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
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.client.GetAliasesResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.AliasMetaData;
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

	private final String indicesPattern = "RYAN";

	public Map<String, Set<AliasMetaData>> aliasIndicesMapping;
	
	private Set<String> indicesName;
	
	private Set<String> aliasName;
	
	public void setIndices() throws IOException {
		Set<String> value = response.getIndices().keySet();
		Set<String> indices = new HashSet<>();
		for (String index : value) {
			if (StringUtils.contains(index.toUpperCase(), indicesPattern)) {
				indices.add(index);
			}
		}
		indicesName = indices;
	}

	public void setAlias() {
		aliasName = new HashSet<>();
		for(String alias : aliasIndicesMapping.keySet()) {
			aliasName.add(alias);
		}
	}
	
	
	public void setAliasMappingIndex() throws IOException {
		GetAliasesRequest request = new GetAliasesRequest();
		Set<String> aliases = response.getIndices().keySet();
		
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
		if (indicesName == null) {
			setIndices();
			setAliasMappingIndex();
			setAlias();
		}
	}

	

}
