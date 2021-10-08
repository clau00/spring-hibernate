package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.*;

public class CreateCourseAndStudentsDemoApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// create a course
			Course course = new Course("a new Course");


			// save the course
			System.out.println("\nSaving the course...");
			session.save(course);
			System.out.println("\nSaved the course: " + course);

			// create the students
			Student student1 = new Student("John", "Doe", "john@doe.com");
			Student student2 = new Student("Mary", "Public", "mary@public.com");

			// add students to the course
			course.addStudent(student1);
			course.addStudent(student2);

			// save the students
			System.out.println("\nSaving students...");
			session.save(student1);
			session.save(student2);
			System.out.println("\nSaved students: " + course.getStudents());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("\nDone!");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
