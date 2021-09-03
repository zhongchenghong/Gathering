/*
package com.museum.util;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchRestClient {

    */
/**
     * ES地址,ip:port
     *//*

    @Value("${elasticsearch.ip}")
    String ipPort;

    @Bean
    public RestClientBuilder restClientBuilder() {

        return RestClient.builder(makeHttpHost(ipPort));
    }


*/
/*    @Bean(name = "highLevelClient")
    public RestHighLevelClient highLevelClient(@Autowired RestClientBuilder restClientBuilder) {
        restClientBuilder.setMaxRetryTimeoutMillis(60000);
        restClientBuilder
        return new RestHighLevelClient(restClientBuilder);
    }*//*



    private HttpHost makeHttpHost(String s) {
        String[] address = s.split(":");
        String ip = address[0];
        int port = Integer.parseInt(address[1]);
        return new HttpHost(ip, port, "http");
    }
}*/
