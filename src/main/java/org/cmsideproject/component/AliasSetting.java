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
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AliasSetting {

//	@Autowired
//	Client client;

	private String aliasName;

	private String indexName;

	public void setAlias() throws IOException {

//		StreamInput sti = new StreamInput().a;
		final CredentialsProvider credentialsProvider =
			    new BasicCredentialsProvider();
			credentialsProvider.setCredentials(AuthScope.ANY,
			    new UsernamePasswordCredentials("elastic", "q6KUX12lvelsACXVMGydkKmb"));

			RestClientBuilder builder = RestClient.builder(
			    new HttpHost("1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io", 9343, "https"))
			    .setHttpClientConfigCallback(new HttpClientConfigCallback() {
			        @Override
			        public HttpAsyncClientBuilder customizeHttpClient(
			                HttpAsyncClientBuilder httpClientBuilder) {
			            return httpClientBuilder
			                .setDefaultCredentialsProvider(credentialsProvider);
			        }
			    });
		
			
			RestHighLevelClient client = new RestHighLevelClient(builder);
//		RestHighLevelClient client = new RestHighLevelClient(
//		        RestClient.builder(
//		                new HttpHost("1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io", 9343, "http")));
		
//		IndicesAliasesRequest request = new IndicesAliasesRequest();
//		AliasActions action = new AliasActions(AliasActions.Type.ADD).index(indexName).alias(aliasName);

//		request = request.addAliasAction(action);
		
		ClusterHealthRequest requests = new ClusterHealthRequest();
		ClusterHealthResponse response = client.cluster().health(requests, RequestOptions.DEFAULT);
		Set<String> indices = response.getIndices().keySet();
	}
}
