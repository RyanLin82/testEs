package org.cmsideproject.config;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@EnableElasticsearchRepositories(basePackages = "org.cmsideproject.minerva.repo")
@Configuration
@PropertySource("classpath:application.properties")
public class EsConfig {

	@Value("${es.userName}")
	private String esUserName;

	@Value("${es.userPassword}")
	private String esUserPassword;

	@Value("${es.port}")
	private int esPort1;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(esUserName, esUserPassword));
		return restTemplate;
	}
//
	@Bean
	public HttpHeaders httpHeader() {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		return headers;
	}

	/////////////

	@Value("${elasticsearch.host1}")
	private String EsHost;

	@Value("${elasticsearch.port1}")
	private int EsPort;

	@Value("${elasticsearch.clustername1}")
	private String EsClusterName;

	@Value("${elasticsearch.xpack.security.user1}")
	private String EsUserInfo;

	private boolean ip6Enabled = true;

	private boolean ip4Enabled = true;

	@Bean
	public Client client() throws Exception {
		boolean enableSsl = true;
		boolean insecure = false;

		Settings settings = Settings.builder().put("client.transport.nodes_sampler_interval", "5s")
				.put("client.transport.sniff", false).put("transport.tcp.compress", true)
				.put("cluster.name", EsClusterName).put("xpack.security.transport.ssl.enabled", enableSsl)
				.put("request.headers.X-Found-Cluster", EsClusterName)
//            .put("xpack.security.user", System.getProperty("xpack.security.user"))
//            .put("xpack.security.user", "elastic:IBOIiPjdARBvU3QXeH4VtIzl")
				.put("xpack.security.user", EsUserInfo)
				.put("xpack.security.transport.ssl.verification_mode", insecure ? "none" : "full").build();

		// Instantiate a TransportClient and add the cluster to the list of addresses to
		// connect to.
		// Only port 9343 (SSL-encrypted) is currently supported. The use of x-pack
		// security features is required.
		TransportClient client = new PreBuiltXPackTransportClient(settings);
		try {
			for (InetAddress address : InetAddress.getAllByName(EsHost)) {
				if ((ip6Enabled && address instanceof Inet6Address)
						|| (ip4Enabled && address instanceof Inet4Address)) {
					client.addTransportAddress(new TransportAddress(address, EsPort));
				}
			}
		} catch (UnknownHostException e) {
		}

		return client;
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}

	@Bean
	Suffix suffix() {
		return new Suffix();
	}
	
	
	@Bean
	public RestHighLevelClient restHighLevelClient() throws IOException {
		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(esUserName, esUserPassword));

		RestClientBuilder builder = RestClient.builder(new HttpHost(EsHost, esPort1, "https"))
				.setHttpClientConfigCallback(new HttpClientConfigCallback() {
					@Override
					public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
						return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
					}
				});

		RestHighLevelClient client = new org.elasticsearch.client.RestHighLevelClient(builder);
		
//		ClusterHealthRequest requests = new ClusterHealthRequest();
//		ClusterHealthResponse response = client.cluster().health(requests, RequestOptions.DEFAULT);
		return client;
	}

}