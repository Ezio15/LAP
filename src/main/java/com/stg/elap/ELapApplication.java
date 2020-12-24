package com.stg.elap;

import java.security.SecureRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.stg.elap.utils.Constants;

@SpringBootApplication(scanBasePackages = { "com.stg.elap" })
@EnableAutoConfiguration
@EntityScan(basePackages = "com.stg.elap.model")
@EnableJpaRepositories(basePackages = { "com.stg.elap.*" })
public class ELapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELapApplication.class, args);
	}
	
	@Bean
	 public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(Constants.STRENGTH, new SecureRandom());
	        return bCryptPasswordEncoder;
	    }

	@Bean 
	public SpringApplicationContext springApplicationContext()
	{
		return new SpringApplicationContext();
	}
}
