package com.alacriti.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class MyGlobalExceptionHandler {

	@ExceptionHandler(value = PaymentServiceException.class)
	public ResponseEntity<ExceptionInfo> handleException(PaymentServiceException e) {

		log.info("Payment Service Exception occurred: {}", e.getMessage());

		return new ResponseEntity<>(new ExceptionInfo("Ex-PS01", e.getMessage(), LocalDateTime.now()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidAmountException.class)
	public ResponseEntity<ExceptionInfo> handleInvalidAmount(InvalidAmountException e) {

		log.info("Invalid Amount Exception occurred: {}", e.getMessage());

		return new ResponseEntity<>(new ExceptionInfo("Ex-IAE01", e.getMessage(), LocalDateTime.now()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidPaymentRefIdException.class)
	public ResponseEntity<ExceptionInfo> handleInvalidPaymentRefId(InvalidPaymentRefIdException e) {

		log.info("Invalid Payment Ref Id  Exception occurred: {}", e.getMessage());

		return new ResponseEntity<>(new ExceptionInfo("Ex-IPE01", e.getMessage(), LocalDateTime.now()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionInfo> handleException(Exception e) {

		log.warn(" Exception occurred: {}", e.getMessage());

		return new ResponseEntity<>(new ExceptionInfo("Ex001", e.getMessage(), LocalDateTime.now()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
