package com.luv2code.springdemo.mvc.customer;

import javax.validation.constraints.*;

import org.springframework.expression.EvaluationException;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {

	private String firstName;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;

	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to 10")
	private int freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "must contain 5 digits or letters")
	private String postalCode;

	@CourseCode()
	private String courseCode;

	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


}
