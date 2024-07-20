package com.alacriti.exception;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PaymentServiceException() {
	}

	public PaymentServiceException(String msg) {
		super(msg);
	}

}
