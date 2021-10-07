package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

			Query<Instructor> query =
					session.createQuery("select i from Instructor i JOIN FETCH i.courses "
										+ "where i.id = :theInstructorId", Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", id);

			// execute query and get instructor
			Instructor instructor = query.getSingleResult();

			System.out.println("\nInstructor: " + instructor);

			// get course
			int courseId = 10;
			Course course = session.get(Course.class, courseId);

			// commit transaction
			session.getTransaction().commit();

			// close the session
			System.out.println("\nSession is now closed!");
			session.close();

			// get courses for the instructor
			System.out.println("\nCourses: " + instructor.getCourses());

			System.out.println("\nDone!");

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
