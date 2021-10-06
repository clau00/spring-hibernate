package com.luv2code.springdemo.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.Fotune.FortuneService;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(" >> TennisCoach: inside of doMyStartupStuff()");

	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(" >> TennisCoach: inside of doMyCleanupStuff()");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


}
