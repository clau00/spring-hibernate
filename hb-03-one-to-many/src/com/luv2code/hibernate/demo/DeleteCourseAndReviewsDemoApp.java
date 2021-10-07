package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemoApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get review
			int reviewId = 9;
			Review review = session.get(Review.class, reviewId);

			// delete the review
			System.out.println("\nDeleting review: " + review);
			session.delete(review);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("\nDone!");

			// get new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// get course
			int courseId = 14;
			Course course = session.get(Course.class, courseId);

			// print the course
			System.out.println("\nCourse: " + course);

			// print the course reviews
			System.out.println("\nReviews: " + course.getReviews());

			// delete course and also the reviews
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
