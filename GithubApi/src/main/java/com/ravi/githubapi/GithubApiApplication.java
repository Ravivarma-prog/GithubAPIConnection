package com.ravi.githubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GithubApiApplication {

	public static void main(String[] args) {
		System.out.println("Welcome");
		SpringApplication.run(GithubApiApplication.class, args);
	}

}
