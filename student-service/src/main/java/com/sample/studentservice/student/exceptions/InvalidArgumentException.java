package com.sample.studentservice.student.exceptions;

public class InvalidArgumentException extends RuntimeException {

	public InvalidArgumentException(String msg) {
		super(msg);
	}
}