package guru.springframework.springmsbrewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author kas
 */
@Profile("google-example")
@Configuration
public class GoogleConfig {

    @Bean
    public RouteLocator googleLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/search-2")
                        .filters(f -> f.rewritePath("/search-2(?<segment>/?.*)", "/${segment}"))
                        .uri("https://google.com")
                        .id("google")
                )
                .build();
    }
}
