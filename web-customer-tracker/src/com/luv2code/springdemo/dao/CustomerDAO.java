package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int customerId);

	void deleteCustomer(int customerId);

}
