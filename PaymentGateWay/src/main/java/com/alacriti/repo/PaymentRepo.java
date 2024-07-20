package com.alacriti.repo;

import com.alacriti.dto.PaymentRequestDTO;
import com.alacriti.dto.PaymentResponseDTO;
import com.alacriti.entity.PaymentData;

public interface PaymentRepo {

	public PaymentResponseDTO makePayment(PaymentRequestDTO dto);

	public PaymentData checkPaymentStatus(String paymentRefID);

}
