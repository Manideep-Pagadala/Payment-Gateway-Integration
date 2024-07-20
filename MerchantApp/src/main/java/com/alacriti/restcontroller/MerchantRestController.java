package com.alacriti.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.dto.PaymentData;
import com.alacriti.dto.PaymentRequestDTO;
import com.alacriti.dto.PaymentResponseDTO;
import com.alacriti.service.MerchantService;

@RestController
@CrossOrigin
public class MerchantRestController {

	private MerchantService service;

	public MerchantRestController(MerchantService service) {
		this.service = service;
	}

	@PostMapping("payment")
	public ResponseEntity<PaymentResponseDTO> makePayment(@RequestBody PaymentRequestDTO dto) {
		return service.makePaymemnt(dto);
	}

	@GetMapping("payment_status/{paymentRefId}")
	public ResponseEntity<PaymentData> getMethodName(@PathVariable String paymentRefId) {
		return service.checkStatus(paymentRefId);

	}

}
