package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemoApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").list();

			// display students
			System.out.println("Students:");
			displayStudents(theStudents);

			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();

			// display students
			System.out.println("Students who have last name of Doe:");
			displayStudents(theStudents);

			// query students: lastName='Doe' OR firstName='Daffy'
			theStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Daffy'").list();

			// display students
			System.out.println("Students who have last name of Doe or first name Daffy:");
			displayStudents(theStudents);

			// query students: email ends with 'ceva.com'
			theStudents = session.createQuery("from Student s where s.email like '%ceva.com'").list();

			// display students
			System.out.println("Students whose email ends with 'ceva.com':");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
		System.out.println("\n");
	}
}
