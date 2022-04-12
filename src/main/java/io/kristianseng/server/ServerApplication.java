package io.kristianseng.server;

import io.kristianseng.server.enumeration.Status;
import io.kristianseng.server.model.Server;
import io.kristianseng.server.repo.ServerRepo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}


	@Bean
	CommandLineRunner run(ServerRepo serverRepo) {
		return args -> {
			serverRepo.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16 GB", "Personal PC", "http://localhost:8080/server1.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.58", "Fedora Linux", "16 GB", "Dell Tower", "http://localhost:8080/server2.png", Status.SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.1.21", "MS 2008", "32 GB", "Web Server", "http://localhost:8080/server3.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.14", "Red Hat Enterprise Linux", "64 GB", "Mail Server", "http://localhost:8080/server4.png", Status.SERVER_DOWN));
		};
	}

	// @Bean 
	// public CorsFilter corsFilter() {

	// 	UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
	// 	CorsConfiguration corsConfiguration = new CorsConfiguration();
    //     corsConfiguration.setAllowCredentials(true);
	// 	corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
	// 	corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
    //     corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
	// 	corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
    //     corsConfiguration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
    //     corsConfiguration.setExposedHeaders(Arrays.asList("x-auth-token"));
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", configuration);
    //     return source;
	// }
}
