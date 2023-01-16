package com.masai.webapp.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@SpringBootApplication
public class MailTest {

	public static void main(String[] args) {
		SpringApplication.run(MailTest.class, args);
		
	}
	
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource ms) {
		
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setValidationMessageSource(ms);
		
		return factoryBean;
	}

}
