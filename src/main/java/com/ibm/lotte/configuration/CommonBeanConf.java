package com.ibm.lotte.configuration;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class CommonBeanConf {

    @Value("${connection.maxtotalconn}")
    int maxTotalConn;
    @Value("${connection.maxperchannel}")
    int maxPerChannel;
    @Value("${connection.connectiontimeout}")
    int connectionTimeout;

    @Bean
    public ClientHttpRequestFactory createRequestFactory(@Value("${connection.timeout}") String maxConn) {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal( maxTotalConn );
        connectionManager.setDefaultMaxPerRoute( maxPerChannel );

        RequestConfig config = RequestConfig.custom().setConnectTimeout( connectionTimeout ).build();
        CloseableHttpClient httpClient = HttpClientBuilder.create().setConnectionManager( connectionManager )
                .setDefaultRequestConfig( config ).build();
        return new HttpComponentsClientHttpRequestFactory( httpClient );
    }

    @Bean
    public RestTemplate createRestTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate( factory );
        return restTemplate;
    }

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setForceEncoding( true );
//        characterEncodingFilter.setEncoding( "UTF-8" );
//        registrationBean.setFilter( characterEncodingFilter );
//        return registrationBean;
//    }
}