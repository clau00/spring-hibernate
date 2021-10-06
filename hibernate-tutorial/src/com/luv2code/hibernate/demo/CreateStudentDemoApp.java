package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemoApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create 3 student objects
			System.out.println("Creating new student objects...");
//			 Student student = new Student("john", "doe", "john.doe@ceva.com");
			 Student student1 = new Student("Paul", "Wall", "paul.wall@ceva.com");
			 Student student2 = new Student("Mary", "Public", "mary@ceva.com");
			 Student student3 = new Student("Bonita", "Applebum", "bonita@ceva.com");

			// start a transaction
			session.beginTransaction();

			// save the student objects
			System.out.println("Saving the students...");
			session.save(student1);
			session.save(student2);
			session.save(student3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}
}
