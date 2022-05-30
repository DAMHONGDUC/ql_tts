package com.example.pv.hanbiro.ql_tts.exception;

public class InvalidUserException extends RuntimeException {
	public InvalidUserException() {
		super();
	}
	
	public InvalidUserException(String message) {
		super(message);
	}
	
	public InvalidUserException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
