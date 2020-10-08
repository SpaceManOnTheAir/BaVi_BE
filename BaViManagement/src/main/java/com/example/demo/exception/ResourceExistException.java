package com.example.demo.exception;

public class ResourceExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceExistException() {
		this("Resource not found!");
	}

	public ResourceExistException(String message) {
		this(message, null);
	}

	public ResourceExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
