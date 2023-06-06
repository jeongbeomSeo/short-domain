package com.spring.shortdomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class ShortDomainApplication {

	public static void main(String[] args) {
		System.out.println("\uD83D\uDD25 Server Open ");

		System.out.println("현재 작업 경로: " + Paths.get(System.getProperty("user.dir")));
		SpringApplication.run(ShortDomainApplication.class, args);
	}

}
