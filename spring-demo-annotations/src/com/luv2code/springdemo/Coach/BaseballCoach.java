package com.luv2code.springdemo.Coach;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.Fotune.FortuneService;

@Component
public class BaseballCoach implements Coach {


	private FortuneService fortuneService;

	BaseballCoach() {
	}

	@Autowired
	public void doSomeCrazyStuff(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Go and eat some burgers";
	}

	@Override
	public String getDailyFortune() {
		return "Baseball Coach: " + fortuneService.getFortune();
	}
}
