package com.esprit.gateway;

import org.apache.http.protocol.HTTP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.ctc.wstx.shaded.msv_core.verifier.jarv.Const;

@SpringBootApplication
@EnableEurekaClient

public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {

		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}

	@Bean
	SecurityWebFilterChain authorization(ServerHttpSecurity http) {

		final String actorsApi = "/actors/api";
		final String moviesApi = "/movies/api";
		final String rateApi = "/rate/api";
		final String bookingApi = "/bookings/api";

		return http.httpBasic(Customizer.withDefaults()).csrf(ServerHttpSecurity.CsrfSpec::disable)
				.authorizeExchange(ae -> ae.pathMatchers(HttpMethod.POST, actorsApi).authenticated()
						.pathMatchers(HttpMethod.PUT, actorsApi).authenticated()
						.pathMatchers(HttpMethod.DELETE, actorsApi).authenticated()
						.pathMatchers(HttpMethod.GET, actorsApi).authenticated()
						.pathMatchers(HttpMethod.POST, moviesApi).authenticated()
						.pathMatchers(HttpMethod.PUT, moviesApi + "/**").authenticated()
						.pathMatchers(HttpMethod.DELETE, moviesApi + "/**").authenticated()
						.pathMatchers(HttpMethod.POST, rateApi).authenticated()
						.pathMatchers(HttpMethod.PUT, rateApi + "/**").authenticated()
						.pathMatchers(HttpMethod.DELETE, rateApi + "/**").authenticated()
						.pathMatchers(HttpMethod.POST, bookingApi).authenticated()
						.pathMatchers(HttpMethod.PUT, bookingApi + "/**").authenticated()
						.pathMatchers(HttpMethod.DELETE, bookingApi + "/**").authenticated()

						.anyExchange().permitAll())
				.build();
	}

	@Bean
	MapReactiveUserDetailsService authentication() {
		return new MapReactiveUserDetailsService(
				User.withDefaultPasswordEncoder().username("test").password("test").roles("USER").build());

	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes().route(r -> r.path("/bookings/**")
				// Pre and Post Filters provided by Spring Cloud Gateway
				.filters(f -> f.addRequestHeader("first-request", "first-request-header")
						.addResponseHeader("first-response", "first-response-header").stripPrefix(1))
				.uri("lb://BOOKINGS-SERVICE"))

				.build();

	}

}
