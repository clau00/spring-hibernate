package com.luv2code.springdemo.Coach;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.Fotune.FortuneService;

@Component
public class CricketCoach implements Coach {

	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	CricketCoach() {
	}

	@Autowired
	public void setFortuneService(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return "Cricket Coach: " + fortuneService.getFortune();
	}
}
