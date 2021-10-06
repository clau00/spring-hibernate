package com.luv2code.springdemo.Fotune;

import org.springframework.stereotype.Component;

@Component
public class AnotherFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Not so lucky";
	}
}
