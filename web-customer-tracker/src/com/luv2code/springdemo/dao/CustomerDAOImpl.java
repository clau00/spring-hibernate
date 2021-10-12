package com.luv2code.springdemo.dao;

import javax.transaction.Transactional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get the query session
		Session session = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> query = session.createQuery("from Customer order by lastName");

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// save/update the customer
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// retrieve from db using primary key
		Customer customer = session.get(Customer.class, customerId);

		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// delete the customer
		Query query = session.createQuery("delete from Customer where id= :customerId");

		query.setParameter("customerId", customerId);

		query.executeUpdate();
	}
}
