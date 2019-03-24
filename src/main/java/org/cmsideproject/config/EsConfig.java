package org.cmsideproject.config;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
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
import org.springframework.web.client.RestTemplate;

@EnableElasticsearchRepositories(basePackages = "org.cmsideproject.minerva.repo")
@Configuration
@PropertySource("classpath:application.properties")
public class EsConfig {

	@Value("${es.userName}")
	private String esUserName;

	@Value("${es.userPassword}")
	private String esUserPassword;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(esUserName, esUserPassword));
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/////////////
	
	@Value("${elasticsearch.host1}")
    private String EsHost;

    @Value("${elasticsearch.port1}")
    private int EsPort;

    @Value("${elasticsearch.clustername1}")
    private String EsClusterName;
    
    @Value("${elasticsearch.xpack.security.user1}")
    private String EsUserInfo;
    
//    @Value("${elasticsearch.xpack.security.pass}")
//    private String EsUserPass;
    
    private boolean ip6Enabled = true;
    
    private boolean ip4Enabled = true;

    @Bean
    public Client client() throws Exception {
    	//
//    	String host = System.getProperty("host");
//        int port = Integer.parseInt(System.getProperty("port", "9343"));

//        String hostBasedClusterName = host.split("\\.", 2)[0];
//        String clusterName = System.getProperty("cluster", hostBasedClusterName);

//        boolean enableSsl = Boolean.parseBoolean(System.getProperty("ssl", "true"));
        boolean enableSsl = true;
        // Note: If enabling IPv6, then you should ensure that your host and network can route it to the Cloud endpoint.
        // (eg Docker disables IPv6 routing by default) - see also the initialization code at the top of this file.
//        ip6Enabled = Boolean.parseBoolean(System.getProperty("ip6", "true"));
//        ip4Enabled = Boolean.parseBoolean(System.getProperty("ip4", "true"));

        // For testing in dev environments, similar to `curl -k` option
//        boolean insecure = Boolean.parseBoolean(System.getProperty("insecure", "false"));
        boolean insecure = false;

//        logger.info("Connecting to cluster: [{}] via [{}:{}] using ssl:[{}]", clusterName, host, port, enableSsl);

        // Build the settings for our client.
        Settings settings = Settings.builder()
            .put("client.transport.nodes_sampler_interval", "5s")
            .put("client.transport.sniff", false)
            .put("transport.tcp.compress", true)
            .put("cluster.name", EsClusterName)
            .put("xpack.security.transport.ssl.enabled", enableSsl)
            .put("request.headers.X-Found-Cluster", EsClusterName)
//            .put("xpack.security.user", System.getProperty("xpack.security.user"))
//            .put("xpack.security.user", "elastic:IBOIiPjdARBvU3QXeH4VtIzl")
            .put("xpack.security.user", EsUserInfo)
            .put("xpack.security.transport.ssl.verification_mode", insecure ? "none" : "full")
            .build();

        // Instantiate a TransportClient and add the cluster to the list of addresses to connect to.
        // Only port 9343 (SSL-encrypted) is currently supported. The use of x-pack security features is required.
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
}