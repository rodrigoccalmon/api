package com.rodrigocalmon.nekibackend.exception;

@SuppressWarnings("serial")
public class EmailException extends RuntimeException {
	public EmailException(String message) {
		super(message);
	}
}