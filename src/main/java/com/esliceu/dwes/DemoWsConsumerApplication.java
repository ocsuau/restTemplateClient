package com.esliceu.dwes;


import com.sun.jndi.toolkit.url.Uri;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

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
        return (String... args) -> {

            Employee employee = restTemplate.getForObject("http://172.16.6.157:8080/demo.json", Employee.class);

			System.out.println(employee);

            Employee[] employees = restTemplate.getForObject("http://172.16.6.157:8080/employees.json", Employee[].class);

			Arrays.asList(employees);
            Employee e = new Employee();
            e.setId(99);
            e.setName("xaxo");
            e.setRole("profe");


            HttpEntity<Employee> request = new HttpEntity<>(e);
            ResponseEntity response = restTemplate.exchange("http://172.16.6.157:8080/demo-post", HttpMethod.POST, request, ResponseEntity.class);

            //System.out.println(response);







		};
	}

}
