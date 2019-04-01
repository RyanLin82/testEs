package org.cmsideproject.component;

import java.io.IOException;
import java.util.Set;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AliasSetting {

	@Autowired
	ClusterHealthResponse response;
	
	@Autowired
	TicketIndices ticketIndices;

	public void setAlias(String indexName, String aliasName) throws IOException {



		IndicesAliasesRequest request = new IndicesAliasesRequest();
		AliasActions action = new AliasActions(AliasActions.Type.ADD).index(indexName).alias(aliasName);

		request = request.addAliasAction(action);

//		this.setRestHighLevelClient();
//		ClusterHealthRequest requests = new ClusterHealthRequest();
//		ClusterHealthResponse response = client.cluster().health(requests, RequestOptions.DEFAULT);
		Set<String> indices = response.getIndices().keySet();
		
//		Set<String> indices2 = ticketIndices.getIndicesName();
		ticketIndices.getIndicesName();
//		ticketIndices.getInstance().getIndicesName();
	}
	
	public void setAlias(TicketSummarySpringDataDTO data) {
		
	}

}
