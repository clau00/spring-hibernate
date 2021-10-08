package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.*;

public class AddCoursesForOneStudentDemoApp {

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

			// get the student from db
			int studentId = 2;
			Student student = session.get(Student.class, studentId);

			System.out.println("\nLoaded student: " + student);
			System.out.println("Courses: " + student.getCourses());

			// create more courses
			Course course1 = new Course("another course for the students");
			Course course2 = new Course("the newest course for the students");

			// add student to courses
			course1.addStudent(student);
			course2.addStudent(student);

			// save the courses
			System.out.println("\nSaving the courses...");
			session.save(course1);
			session.save(course2);

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
