package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailsDemoApp {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get instructor detail object
			int theId = 1;
			System.out.println("\nGetting the instructor detail with id: " + theId);
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("\nInstructor detail: " + instructorDetail);

			// breaking the bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);

			// delete the instructor detail
			System.out.println("\nDeleting instructor detail: " + instructorDetail);
			session.delete(instructorDetail);

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
