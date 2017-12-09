package com.xingbook.zxott.zxott;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ZxottApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZxottApplication.class, args);
	}
}
