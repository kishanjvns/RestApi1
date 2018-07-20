package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such record")
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason="No element in database")
public class NotFoundException extends BaseException {

	public NotFoundException(String message) {
		super(message);
	}
	public NotFoundException(int errorCode,String message) {
		super(errorCode, message);
	}
}
