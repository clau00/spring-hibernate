package com.luv2code.springdemo.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.Fotune.FortuneService;

@Component
public class AnotherCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	AnotherCoach() {
	}

	@Override
	public String getDailyWorkout() {
		return "Have some rest";
	}

	@Override
	public String getDailyFortune() {
		return "Another Coach: " + fortuneService.getFortune();
	}
}
