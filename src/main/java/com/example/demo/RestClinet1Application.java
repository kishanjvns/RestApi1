package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Greeting;


public class RestClinet1Application {

	private static final Logger log = LoggerFactory.getLogger(RestClinet1Application.class);
	public static void main(String[] args) {
		RestTemplate template=new RestTemplate();
		String url="http://localhost:8080/hello-world?name=kishan";
		Greeting greeting=template.getForObject(url, Greeting.class);
		System.out.println(greeting);
	}
}
