package com.architecture.microservices.proxyservice.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.RoutesEndpoint;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
@EnableAutoConfiguration
public class SwaggerResourceConfig implements SwaggerResourcesProvider {
    
    private final RoutesEndpoint routesEndpoint;
    
    public SwaggerResourceConfig(RoutesEndpoint routesEndpoint) {
        this.routesEndpoint = routesEndpoint;
    }

    @Override
    public List<SwaggerResource> get() {
        final List<SwaggerResource> resources = new ArrayList<SwaggerResource>();

//        routesEndpoint.invoke().forEach((key, value) -> {
//            if (value.startsWith("zuul")) {
//                resources.add(swaggerResource(value, "/v2/api-docs", "2.0"));
//            } else if (!value.startsWith("consul")) {
//                resources.add(swaggerResource(value, "/api/" + value + "/v2/api-docs", "2.0"));
//            }
//        });
        
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
