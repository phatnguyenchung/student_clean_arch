package com.example.studentcleanarch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentCleanArchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentCleanArchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Thread.currentThread().join();
	}
}
