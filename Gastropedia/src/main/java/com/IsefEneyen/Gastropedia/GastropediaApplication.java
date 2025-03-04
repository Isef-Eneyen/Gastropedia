package com.IsefEneyen.Gastropedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.IsefEneyen.Gastropedia.Models")
public class GastropediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GastropediaApplication.class, args);
	}

}
