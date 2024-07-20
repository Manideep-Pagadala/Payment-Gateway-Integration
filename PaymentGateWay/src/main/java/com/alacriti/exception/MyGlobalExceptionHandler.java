package com.alacriti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class MyGlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception e) {

		log.warn("Unexpected error occurred", e);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}

	@ExceptionHandler(InvalidAmountException.class)
	public ResponseEntity<String> handleInvalidAmount(InvalidAmountException e) {

		log.info("Invalid Amount Exception occurred: {}", e.getMessage());

		return ResponseEntity.badRequest().body(e.getMessage());
	}

	@ExceptionHandler(InvalidPaymentRefIdException.class)
	public ResponseEntity<String> handleInvalidPaymentRefId(InvalidPaymentRefIdException e) {

		log.info("Invalid Payment ref ID Exception occurred: {}", e.getMessage());

		return ResponseEntity.badRequest().body(e.getMessage());
	}

	@ExceptionHandler(DBConnectionInterruptedException.class)
	public ResponseEntity<String> handleDBConnectionInteruption(DBConnectionInterruptedException e) {

		log.error("Database connection interrupted: {}", e.getMessage());

		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body("Database connection interrupted. Please try again later.");
	}
}
