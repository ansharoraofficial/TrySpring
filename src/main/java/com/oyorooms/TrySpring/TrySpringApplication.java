package com.oyorooms.TrySpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableCaching
public class TrySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrySpringApplication.class, args);
	}

}
