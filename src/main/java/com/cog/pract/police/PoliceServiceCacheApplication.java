package com.cog.pract.police;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PoliceServiceCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliceServiceCacheApplication.class, args);
	}

}
