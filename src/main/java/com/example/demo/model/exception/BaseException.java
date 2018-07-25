package com.example.demo.model.exception;

public class BaseException extends RuntimeException {
	private int errorCode;
	
	
	public BaseException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;		
	}
	public BaseException(){
		
	}
	public BaseException(String message) {
		super(message);
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
}
