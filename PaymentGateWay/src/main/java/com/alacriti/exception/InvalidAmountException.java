package com.alacriti.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidAmountException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidAmountException() {
	}

	public InvalidAmountException(String msg) {
		super(msg);
	}

}
