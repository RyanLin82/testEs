package org.cmsideproject.config;

import org.cmsideproject.mivera.resttemplate.CustomRestTemplateCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

//
@Configuration
// @ConditionalOnClass(JestClient.class)
// @EnableElasticsearchRepositories(basePackages =
// "org.cmsideproject.book.repository")
public class EsConfig {
	//
	// @Value("${elasticsearch.host}")
	// private String EsHost;
	//
	// @Value("${elasticsearch.port}")
	// private int EsPort;
	//
	// @Value("${elasticsearch.clustername}")
	// private String EsClusterName;
	//
	// @Bean
	// public JestClient client() throws Exception {
	//
	//
	// /*
	// * for local es
	// */
	//// TransportClient transportClient = null;
	//// try {
	//// // 配置信息
	//// Settings esSetting = Settings.builder()
	//// .put("cluster.name", EsClusterName)
	//// //增加嗅探机制，找到ES集群
	//// .put("client.transport.sniff", true)
	//// //增加线程池个数为1
	////// .put("thread_pool.search.size", Integer.parseInt(poolSize))
	//// .build();
	////
	//// transportClient = new PreBuiltTransportClient(esSetting);
	//// TransportAddress inetSocketTransportAddress = new
	// TransportAddress(InetAddress.getByName(EsHost),
	//// Integer.valueOf(EsPort));
	//// transportClient.addTransportAddresses(inetSocketTransportAddress);
	//// } catch (UnknownHostException e) {
	//// e.printStackTrace();
	//// }
	////
	//// return transportClient;
	//
	// JestClientFactory factory = new JestClientFactory();
	// factory.setHttpClientConfig(new
	// HttpClientConfig.Builder("https://1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io:9243/")
	// .multiThreaded(true)
	// .build());
	// JestClient client = factory.getObject();
	//
	// return client;
	// }
	//
	//// @Bean
	//// public ElasticsearchOperations elasticsearchTemplate(JestClient client)
	// throws Exception {
	//// return new JestElasticsearchTemplate(client);
	//// }
	//
	// // Embedded Elasticsearch Server
	// /*
	// * @Bean public ElasticsearchOperations elasticsearchTemplate() { return
	// new
	// * ElasticsearchTemplate(nodeBuilder().local(true).node().client()); }
	// */
	//

	// @Bean("restTemplateProxy")
	// public RestTemplate restTemplateProxy(RestTemplateBuilder builder) throws
	// KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
	// String proxyHost = "poowsg";
	// String proxyPort = "2";
	//
	// int proxyPortNum = 2;
	// HttpClientBuilder clientBuilder =HttpClientBuilder.create();
	// clientBuilder.useSystemProperties();
	// clientBuilder.setProxy(new HttpHost(proxyHost, proxyPortNum));
	// TrustStrategy acceptingTrustStrategy = (X509Certificate[] certificate,
	// String authType ) -> true;
	// SSLContext sslcontext;
	//
	// sslcontext = SSLContexts.custom().loadTrustMaterial(null,
	// acceptingTrustStrategy).build();
	//
	// SSLConnectionSocketFactory csf = new
	// SSLConnectionSocketFactory(sslcontext);
	//
	// CloseableHttpClient client =
	// clientBuilder.setSSLSocketFactory(csf).build();
	//
	// HttpComponentsClientHttpRequestFactory factory = new
	// HttpComponentsClientHttpRequestFactory();
	//
	// factory.setHttpClient(client);
	//
	// RestTemplate restTemplate = builder.build();
	// restTemplate.setRequestFactory(factory);
	// return restTemplate;
	//
	// }

	@Value("${es.userName}")
	private String esUserName;

	@Value("${es.userPassword}")
	private String esUserPassword;

	@Bean(name = "RestTempateCus")
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("elastic", "q6KUX12lvelsACXVMGydkKmb"));
		return restTemplate;
	}

	@Bean
	public HttpHeaders httpHeader() {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		return headers;
	}
	
	@Bean
	public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
	    return new CustomRestTemplateCustomizer();
	}
}