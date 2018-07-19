package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
@RestController
public class CustomerApi {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method=RequestMethod.POST)
	
	public String saveCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
}
