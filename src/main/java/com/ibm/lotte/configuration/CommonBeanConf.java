package com.ibm.lotte.configuration;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonBeanConf {

	@Value("${connection.maxtotalconn}")
	int maxTotalConn;
	@Value("${connection.maxperchannel}")
	int maxPerChannel;

	@Bean
	public ClientHttpRequestFactory createRequestFactory(@Value("${connection.timeout}") String maxConn) {
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(maxTotalConn);
		connectionManager.setDefaultMaxPerRoute(maxPerChannel);

		RequestConfig config = RequestConfig.custom().setConnectTimeout(100000).build();
		CloseableHttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connectionManager)
				.setDefaultRequestConfig(config).build();
		return new HttpComponentsClientHttpRequestFactory(httpClient);
	}

	@Bean
	public RestTemplate createRestTemplate(ClientHttpRequestFactory factory) {
		RestTemplate restTemplate = new RestTemplate(factory);
		// restTemplate.setErrorHandler(new RestResponseErrorHandler());
		// restTemplate.setMessageConverters(createMessageConverters());
		return restTemplate;
	}

	private List<HttpMessageConverter<?>> createMessageConverters() {
		List<HttpMessageConverter<?>> mConverters = new ArrayList<>();
		mConverters.add(new MappingJackson2HttpMessageConverter());
		return mConverters;
	}
}