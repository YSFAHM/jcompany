package com.yteam.jcompany.exception;

public class ValidationException extends RuntimeException {
    private String message;
    public ValidationException(String message) {
		super(message);
		this.message = message;
	}
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
