package org.cmsideproject.component;

import java.io.IOException;
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

	public Set<String> indicesName;

	public Map<String, List<String>> aliasIndicesMapping;
	
	private void setIndices() throws IOException {
		Set<String> value = response.getIndices().keySet();
		
		Set<String> indices = new HashSet<>();
		for (String index : value) {
			if (StringUtils.contains(index, "CZ") || StringUtils.contains(index, "cz")) {
				indices.add(index);
			}
		}
		indicesName = indices;
	}

	private void setAliasMappingIndex() {
		GetAliasesRequest request = new GetAliasesRequest();
		GetAliasesRequest requestWithAlias = new GetAliasesRequest("alias1");
		GetAliasesRequest requestWithAliases =
		        new GetAliasesRequest(new String[]{"alias1", "alias2"});
		
		GetAliasesResponse responses = client.admin().indices().ali.getAlias(request, RequestOptions.DEFAULT);

		Map<String, Set<AliasMetaData>> aliases = responses.getAliases();
		
//		GetAliasesResponse response = client.admin().indices().getAliases(requestWithAliases);
		for(String indexName : indicesName) {
			response.getAliases();
		}
	}
	
	@PostConstruct
	private void init() throws IOException {
		if (indicesName == null) {
			setIndices();
		}
	}

	public Set<String> getIndicesName() {
		return indicesName;
	}

}
