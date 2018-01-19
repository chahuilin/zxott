package com.xingbook.zxott.zxott;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableSwagger2
public class ZxottApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZxottApplication.class, args);
	}
}
