//package org.cmsideproject.config;
//
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.X509Certificate;
//
//import javax.net.ssl.SSLContext;
//
//import org.apache.http.HttpHost;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLContexts;
//import org.apache.http.conn.ssl.TrustStrategy;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
////
////@Configuration
////@ConditionalOnClass(JestClient.class)
////@EnableElasticsearchRepositories(basePackages = "org.cmsideproject.book.repository")
//public class EsConfig {
////
////	@Value("${elasticsearch.host}")
////	private String EsHost;
////
////	@Value("${elasticsearch.port}")
////	private int EsPort;
////
////	@Value("${elasticsearch.clustername}")
////	private String EsClusterName;
////
////	@Bean
////    public JestClient client() throws Exception {
////
////    	
////    	/*
////    	 * for local es
////    	 */
//////    	TransportClient transportClient = null;
//////        try {
//////            // 配置信息
//////            Settings esSetting = Settings.builder()
//////                    .put("cluster.name", EsClusterName)
//////                    //增加嗅探机制，找到ES集群
//////                    .put("client.transport.sniff", true)
//////                    //增加线程池个数为1
////////                    .put("thread_pool.search.size", Integer.parseInt(poolSize))
//////                    .build();
//////
//////            transportClient = new PreBuiltTransportClient(esSetting);
//////            TransportAddress inetSocketTransportAddress = new TransportAddress(InetAddress.getByName(EsHost),
//////                    Integer.valueOf(EsPort));
//////            transportClient.addTransportAddresses(inetSocketTransportAddress);
//////        } catch (UnknownHostException e) {
//////            e.printStackTrace();
//////        }
//////        
//////        return transportClient;
////    	
////		JestClientFactory factory = new JestClientFactory();
////        factory.setHttpClientConfig(new HttpClientConfig.Builder("https://1cd79fd6efe94d0091fd28c2d7cb3191.ap-southeast-1.aws.found.io:9243/")
////                .multiThreaded(true)
////                .build());
////        JestClient client = factory.getObject();
////        
////        return client;
////    }
////
//////	@Bean
//////	public ElasticsearchOperations elasticsearchTemplate(JestClient client) throws Exception {
//////		return new JestElasticsearchTemplate(client);
//////	}
////
////	// Embedded Elasticsearch Server
////	/*
////	 * @Bean public ElasticsearchOperations elasticsearchTemplate() { return new
////	 * ElasticsearchTemplate(nodeBuilder().local(true).node().client()); }
////	 */
////
//	
//	@Bean("restTemplateProxy")
//	public RestTemplate restTemplateProxy(RestTemplateBuilder builder) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
//		String proxyHost = "poowsg";
//		String proxyPort = "2";
//		
//		int proxyPortNum = 2;
//		HttpClientBuilder clientBuilder =HttpClientBuilder.create();
//		clientBuilder.useSystemProperties();
//		clientBuilder.setProxy(new HttpHost(proxyHost, proxyPortNum));
//		TrustStrategy acceptingTrustStrategy = (X509Certificate[] certificate, String authType ) -> true;
//		SSLContext sslcontext;
//		
//		sslcontext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
//		
//		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslcontext);
//		
//		CloseableHttpClient client = clientBuilder.setSSLSocketFactory(csf).build();
//		
//		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//		
//		factory.setHttpClient(client);
//		
//		RestTemplate restTemplate = builder.build();
//		restTemplate.setRequestFactory(factory);
//		return restTemplate;
//		
//	}
//}