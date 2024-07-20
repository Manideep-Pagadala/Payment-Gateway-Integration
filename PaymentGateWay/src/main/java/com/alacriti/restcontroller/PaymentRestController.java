package com.alacriti.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.dto.PaymentRequestDTO;
import com.alacriti.dto.PaymentResponseDTO;
import com.alacriti.entity.PaymentData;
import com.alacriti.service.PaymentService;

@RestController
@CrossOrigin
public class PaymentRestController {

	private PaymentService service;

	public PaymentRestController(PaymentService service) {
		this.service = service;
	}

	@PostMapping("payment")
	public ResponseEntity<PaymentResponseDTO> makePayment(@RequestBody PaymentRequestDTO dto) {

		PaymentResponseDTO response = service.handlePayment(dto);
		HttpStatus code = (response.getPaymentRefID() != null) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

		return new ResponseEntity<>(response, code);
	}

	@GetMapping("payment_status/{paymentRefId}")
	public ResponseEntity<PaymentData> getPaymentStatusBYRefId(@PathVariable String paymentRefId) {
		PaymentData response = service.getPaymentStatus(paymentRefId);

		HttpStatus code = (response.getStatus().isEmpty() || response.getStatus().isBlank()) ? HttpStatus.BAD_REQUEST
				: HttpStatus.OK;

		return new ResponseEntity<>(response, code);
	}

}
