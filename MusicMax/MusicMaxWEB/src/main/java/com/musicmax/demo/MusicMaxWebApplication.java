package com.musicmax.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class MusicMaxWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicMaxWebApplication.class, args);
	}

}
