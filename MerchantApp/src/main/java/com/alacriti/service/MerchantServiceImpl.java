package com.alacriti.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alacriti.dto.PaymentData;
import com.alacriti.dto.PaymentRequestDTO;
import com.alacriti.dto.PaymentResponseDTO;
import com.alacriti.exception.InvalidAmountException;
import com.alacriti.exception.InvalidPaymentRefIdException;
import com.alacriti.exception.PaymentServiceException;

@Service
public class MerchantServiceImpl implements MerchantService {

	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${url.checkStatus}")
	String statusURL;

	@Value("${url.makePayment}")
	String paymentURL;

	@Override
	public ResponseEntity<PaymentResponseDTO> makePaymemnt(PaymentRequestDTO dto) {

		Double amount = dto.getAmount();

		if (amount <= 0 || amount == null) {
			throw new InvalidAmountException(" Inavlid Amount..!");
		}

		try {

			return restTemplate.postForEntity(paymentURL, dto, PaymentResponseDTO.class);

		} catch (ResourceAccessException e) {

			throw new PaymentServiceException("Gateway Server connection failed..!");

		} catch (RestClientException e) {

			throw new PaymentServiceException(extractProperExceptionMsg(e));
		}

	}

	@Override
	public ResponseEntity<PaymentData> checkStatus(String paymentRefId) {

		if (paymentRefId.isEmpty() || paymentRefId.isBlank()) {
			throw new InvalidPaymentRefIdException(" Invalid Ref Id");
		}

		try {

			return restTemplate.getForEntity(statusURL + paymentRefId, PaymentData.class);

		} catch (ResourceAccessException e) {

			throw new PaymentServiceException("Gateway Server connection failed..!");

		} catch (RestClientException e) {

			throw new PaymentServiceException(extractProperExceptionMsg(e));

		}
	}

	private String extractProperExceptionMsg(RestClientException e) {

		String errorMessage = e.getMessage();

		System.out.println(errorMessage);

		if (errorMessage.equals("400 : \" Invalid Ref Id\""))
			return "Invalid Reference ID";
		else if (errorMessage.contains("Invalid Amount..!"))
			return "Invalid Amount";
		else
			return "Unexpected error occurred, please try again";

	}

}
