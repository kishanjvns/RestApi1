package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.Customer;
import com.example.demo.model.exception.BaseException;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerApi {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/customer", method = RequestMethod.POST)

	public void saveCustomer(@RequestBody Customer customer, HttpServletResponse httpServletResponse) {
		try {
			
			if (customer.getFirstName() == null || customer.getLastName() == null) {
				throw new BaseException(HttpStatus.BAD_REQUEST.value() ,"enter the first name");
				/*httpServletResponse.sendError(httpServletResponse.SC_BAD_REQUEST, "provide data");
				    return;
				 * */
			}

			String id = customerService.createCustomer(customer);

			httpServletResponse.getWriter().write("created with ID : " + id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@ExceptionHandler(value = BaseException.class)
	public Map<String, String> handleCustomeExceptin(BaseException baseException) {
		Map<String, String> map = new HashMap<>();
		map.put("ErrorCode", "" + baseException.getErrorCode());
		map.put("message", baseException.getMsg());
		return map;
	}
}
