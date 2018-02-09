package com.nbr.auth;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.nbr.auth.domain.Account;
import com.nbr.auth.service.AccountRepository;

@SpringBootApplication
@EnableResourceServer
public class SpringAuthServerApplication {

	@Bean
	CommandLineRunner loader(AccountRepository accountRepository) {
		return args -> {
			Stream.of("nand,password").map(tpl -> tpl.split(","))
					.forEach(tpl -> accountRepository.save(new Account(tpl[0], tpl[1], true)));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthServerApplication.class, args);
	}

}
