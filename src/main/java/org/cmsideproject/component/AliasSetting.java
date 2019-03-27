package org.cmsideproject.component;

import java.io.IOException;
import java.util.Set;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AliasSetting {


	private String aliasName;

	private String indexName;
	
	@Autowired
	RestHighLevelClient client;
	
//	@Autowired
//	TicketIndices ticketIndices;
	
	public void setAlias() throws IOException {

//		StreamInput sti = new StreamInput().a;
		
//		RestHighLevelClient client = new RestHighLevelClient(
//		        RestClient.builder(
//		                new HttpHost("1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io", 9343, "http")));
		
//		IndicesAliasesRequest request = new IndicesAliasesRequest();
//		AliasActions action = new AliasActions(AliasActions.Type.ADD).index(indexName).alias(aliasName);

//		request = request.addAliasAction(action);
		ClusterHealthRequest requests = new ClusterHealthRequest();
		ClusterHealthResponse response = client.cluster().health(requests, RequestOptions.DEFAULT);
		Set<String> indices = response.getIndices().keySet();
//		ticketIndices.getInstance().getIndicesName();
	}
}
