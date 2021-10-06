package com.luv2code.springdemo.coach;

import com.luv2code.springdemo.fortune.FortuneService;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
