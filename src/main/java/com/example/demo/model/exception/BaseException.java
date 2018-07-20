package com.example.demo.model.exception;

public class BaseException extends RuntimeException {
	private int errorCode;
	private String msg;
	
	public BaseException(int errorCode, String msg) {
		super();
		this.errorCode = errorCode;
		this.msg = msg;
	}
	public BaseException(){
		
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
