package org.cmsideproject.component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
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

		Set<String> indices = response.getIndices().keySet();

		ticketIndices.getIndicesName();
	}

	public void setAlias(TicketSummarySpringDataDTO data) throws ParseException {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(df.parse(data.getDoneDate()));
		String alias = Integer.toString(calendar.YEAR) + Integer.toString(calendar.MONTH+1);
		IndicesAliasesRequest request = new IndicesAliasesRequest();
		AliasActions action = new AliasActions(AliasActions.Type.ADD).index("test_ryan_"+data.getJira()).alias("testtt");

		request = request.addAliasAction(action);

	}

}
