package guru.springframework.springmsbrewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kas
 */
@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator localHostRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/beer/**", "/api/v1/beer*").uri("http://localhost:8080").id("beer-service"))
                .build();
    }
}