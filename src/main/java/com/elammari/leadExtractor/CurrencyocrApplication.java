package com.elammari.leadExtractor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurrencyocrApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyocrApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String value = ImageParse.parseImage("test.png");
            System.out.println(">>>>>>>" + value);

        };
    }
}

