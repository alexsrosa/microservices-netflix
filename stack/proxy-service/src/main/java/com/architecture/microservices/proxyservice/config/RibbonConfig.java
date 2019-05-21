package com.architecture.microservices.proxyservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandFactory;
import org.springframework.cloud.netflix.zuul.filters.route.apache.HttpClientRibbonCommandFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {

    @LoadBalanced
    @Bean
    public RibbonCommandFactory ribbonCommandFactory(SpringClientFactory clientFactory, ZuulProperties zuulProperties) {
        return new HttpClientRibbonCommandFactory(clientFactory, zuulProperties);
    }
}
