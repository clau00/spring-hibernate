package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.*;

public class DeleteCourseDemoApp {

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

			// get the course from db
			int courseId = 10;
			Course course = session.get(Course.class, courseId);

			// delete the course
			System.out.println("\nDeleting the course..." + course);
			session.delete(course);

			// get courses for student
			int studentId = 1;
			Student student = session.get(Student.class, studentId);

			System.out.println("\nLoaded student: " + student);
			System.out.println("Courses: " + student.getCourses());

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
