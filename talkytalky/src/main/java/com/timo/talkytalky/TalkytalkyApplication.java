package com.timo.talkytalky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.timo.talkytalky")
@SpringBootApplication
public class TalkytalkyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalkytalkyApplication.class, args);
	}
}
