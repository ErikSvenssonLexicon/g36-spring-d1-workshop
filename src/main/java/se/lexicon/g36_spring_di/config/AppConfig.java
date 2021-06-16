package se.lexicon.g36_spring_di.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "se.lexicon.g36_spring_di")
public class AppConfig {
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);		
	}

}
