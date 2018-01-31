package com.esliceu.dwes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class DemoWsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWsConsumerApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	CommandLineRunner runner(RestTemplate restTemplate){
		return (args)->{

			Employee employee = restTemplate.getForObject("http://localhost:8080/demo.json",  Employee.class);

			System.out.println(employee);

			Employee[] employees = restTemplate.getForObject("http://localhost:8080/employees.json", Employee[].class);

			Arrays.asList(employees);
		};
	}

}
