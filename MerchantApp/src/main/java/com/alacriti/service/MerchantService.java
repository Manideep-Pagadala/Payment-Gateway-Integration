package com.alacriti.service;

import org.springframework.http.ResponseEntity;

import com.alacriti.dto.PaymentData;
import com.alacriti.dto.PaymentRequestDTO;
import com.alacriti.dto.PaymentResponseDTO;

public interface MerchantService {

	public ResponseEntity<PaymentResponseDTO> makePaymemnt(PaymentRequestDTO dto);

	public ResponseEntity<PaymentData> checkStatus(String paymentRefId);

}
