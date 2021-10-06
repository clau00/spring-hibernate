package com.luv2code.springdemo;

import com.luv2code.springdemo.coach.Coach;
import com.luv2code.springdemo.coach.TrackCoach;

public class MyApp {
	public static void main(String[] args) {

		Coach theCoach = new TrackCoach();

		System.out.println(theCoach.getDailyWorkout());
	}
}
