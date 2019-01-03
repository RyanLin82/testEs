package org.cmsideproject.mivera.resttemplate;

import java.io.IOException;

import org.jboss.logging.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;


public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
	private static Logger LOGGER = Logger.getLogger(CustomClientHttpRequestInterceptor.class);

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		logRequestDetails(request);
		return execution.execute(request, body);
	}

	private void logRequestDetails(HttpRequest request) {
//		LOGGER.info("Headers: {}", request.getHeaders());
//		LOGGER.info("Request Method: {}", request.getMethod());
//		LOGGER.info("Request URI: {}", request.getURI());
	}
}
