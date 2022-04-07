package io.kristianseng.server;

import io.kristianseng.server.model.Server;
import io.kristianseng.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}


	@Bean
	CommandLineRunner run(ServerRepo serverRepo) {
		return args -> {
			serverRepo.save(new Server());
			serverRepo.save(new Server());
			serverRepo.save(new Server());
			serverRepo.save(new Server());
		};
	}
}
