package com.bturkmen.springaop.todo.utils;

import lombok.Data;

@Data
public class DataResult<T> extends Result {

	private T data;
	
	public DataResult(T data,boolean success, String message) {
		super(success, message);
		this.data = data;
	}

}
