package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemoApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from DB
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);

			System.out.println("\nInstructor: " + instructor);

			// get courses for the instructor
			System.out.println("\nCourses: " + instructor.getCourses());

			// get course
			int courseId = 10;
			Course course = session.get(Course.class, courseId);

			// delete the course
			System.out.println("\nDeleting course: " + course);

			session.delete(course);

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
