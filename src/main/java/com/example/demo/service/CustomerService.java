package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {
	String createCustomer(Customer customer);
	Customer getCustomerByName(String name);	
	List<Customer> getAllCustomer();
}
