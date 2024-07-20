package com.alacriti.service;

import org.springframework.stereotype.Service;

import com.alacriti.dto.PaymentRequestDTO;
import com.alacriti.dto.PaymentResponseDTO;
import com.alacriti.entity.PaymentData;
import com.alacriti.repo.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {

	private PaymentRepo repo;

	public PaymentServiceImpl(PaymentRepo repo) {
		this.repo = repo;
	}

	@Override
	public PaymentResponseDTO handlePayment(PaymentRequestDTO dto) {
		return repo.makePayment(dto);
	}

	@Override
	public PaymentData getPaymentStatus(String paymentRefID) {
		return repo.checkPaymentStatus(paymentRefID);
	}

}
