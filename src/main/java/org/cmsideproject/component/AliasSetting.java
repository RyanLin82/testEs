package org.cmsideproject.component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.cmsideproject.log.MinervaLog;
import org.cmsideproject.log.MinervaLogImp;
import org.cmsideproject.minerva.entity.TicketSummarySpringDataDTO;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.AcknowledgedResponse;
import org.elasticsearch.cluster.metadata.AliasAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class AliasSetting {

	private MinervaLog log = new MinervaLogImp(this.getClass());

//	@Autowired
//	ClusterHealthResponse response;

//	@Autowired
//	RestHighLevelClient client;

	public void setAlias(String indexName, String aliasName) throws IOException {

		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY,
				new UsernamePasswordCredentials("elastic", "q6KUX12lvelsACXVMGydkKmb"));

		RestClientBuilder builder = RestClient
				.builder(new HttpHost("1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io", 9343, "https"))
				.setHttpClientConfigCallback(new HttpClientConfigCallback() {
					@Override
					public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
						return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
					}
				});

		RestHighLevelClient client = new org.elasticsearch.client.RestHighLevelClient(builder);

		IndicesAliasesRequest request = new IndicesAliasesRequest();
		AliasActions action = new AliasActions(AliasActions.Type.ADD).alias(indexName).index(aliasName);

		request = request.addAliasAction(action);

		RequestOptions requestOption = new RequestOptions().toBuilder().addHeader(name, value);;
		
		client.indices().updateAliases(request, RequestOptions.DEFAULT);

//		ticketIndices.getIndicesName();

	}

	public void setAlias(List<String> indexName, String aliasName) throws IOException {

		IndicesAliasesRequest request = new IndicesAliasesRequest();
		for (String value : indexName) {
			AliasActions action = new AliasActions(AliasActions.Type.ADD).index(value).alias("ryan222222");
			request = request.addAliasAction(action);
			log.info("index", value, "alias", "ryan222222", "");
		}

	}

	public void setAlias(TicketSummarySpringDataDTO data) throws ParseException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyyMM");

		String index = "test_ryan_" + data.getJira().toLowerCase();
		String alias = "ryan_" + df2.format(df.parse(data.getDoneDate()));

		IndicesAliasesRequest request = new IndicesAliasesRequest();
		AliasActions action = new AliasActions(AliasActions.Type.ADD).index(index).alias("ryan_test_1");

		request = request.addAliasAction(action);

		log.info("index", index, "alias", alias, data);
	}

}
