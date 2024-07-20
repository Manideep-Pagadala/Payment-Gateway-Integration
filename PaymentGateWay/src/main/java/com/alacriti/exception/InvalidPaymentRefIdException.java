package com.alacriti.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidPaymentRefIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPaymentRefIdException() {
	}

	public InvalidPaymentRefIdException(String msg) {
		super(msg);
	}

}
