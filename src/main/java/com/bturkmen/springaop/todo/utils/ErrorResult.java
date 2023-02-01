package com.bturkmen.springaop.todo.utils;

public class ErrorResult extends Result {

	public ErrorResult(String message) {
		super(false, message);
	}

}
