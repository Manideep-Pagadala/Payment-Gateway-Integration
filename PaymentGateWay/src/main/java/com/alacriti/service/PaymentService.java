package com.alacriti.service;

import com.alacriti.dto.PaymentRequestDTO;
import com.alacriti.dto.PaymentResponseDTO;
import com.alacriti.entity.PaymentData;

public interface PaymentService {

	public PaymentResponseDTO handlePayment(PaymentRequestDTO dto);

	public PaymentData getPaymentStatus(String paymentRefID);

}
