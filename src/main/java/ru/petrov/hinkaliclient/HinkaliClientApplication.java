package ru.petrov.hinkaliclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HinkaliClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HinkaliClientApplication.class, args);
		System.out.println("hello");
	}

}
