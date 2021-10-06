package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.luv2code.springdemo.Coach.Coach;
import com.luv2code.springdemo.Coach.SwimCoach;
import com.luv2code.springdemo.Fortune.FortuneService;
import com.luv2code.springdemo.Fortune.SadFortuneService;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {

	@Bean
	public FortuneService sadFortuneService(){
		return new SadFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
