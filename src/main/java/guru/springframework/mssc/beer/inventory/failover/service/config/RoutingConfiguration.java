package guru.springframework.mssc.beer.inventory.failover.service.config;

import guru.springframework.mssc.beer.inventory.failover.service.handlers.BeerInventoryFailoverHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(BeerInventoryFailoverHandler handler) {
        return RouterFunctions.route()
                .path("/inventory-failover", builder -> builder.GET("", accept(MediaType.APPLICATION_JSON), handler::getFailover))
                .build();
    }
}
