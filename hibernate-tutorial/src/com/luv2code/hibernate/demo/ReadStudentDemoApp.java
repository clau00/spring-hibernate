package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemoApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create student object
			System.out.println("Creating new student objects...");
			 Student tempStudent = new Student("Daffy", "Duck", "duffy@duck.com");

			// start a transaction
			session.beginTransaction();

			// save the student objects
			System.out.println("Saving the student...");
			session.save(tempStudent);

			//find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());

			// commit transaction
			session.getTransaction().commit();

			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve the student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get complete: " + myStudent);

			//  commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}
}
