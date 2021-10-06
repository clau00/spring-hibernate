package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemoApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 3;

			// get a new session and start transaction
			session.beginTransaction();

			// retrieve the student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			// delete student
			System.out.println("Deleting student...");
			session.delete(myStudent);

			//  commit the transaction
			session.getTransaction().commit();

			// NEW CODE

			session = factory.getCurrentSession();
			session.beginTransaction();

			// delete student with firstName='Scooby'
			String firstName = "Scooby";
			System.out.println("\nDeleting student with first name " + firstName);
			session.createQuery("delete from Student where firstName='" + firstName + "'")
					.executeUpdate();

			//  commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}
}
