package com.alacriti.exception;

import org.springframework.stereotype.Component;

@Component
public class DBConnectionInterruptedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBConnectionInterruptedException() {
	}

	public DBConnectionInterruptedException(String msg) {
		super(msg);
	}

}
