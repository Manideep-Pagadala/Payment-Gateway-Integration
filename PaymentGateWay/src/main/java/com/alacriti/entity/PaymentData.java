package com.alacriti.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class PaymentData {

	private String paymentRefID;
	private String merchantId;
	private Double amount;
	private String currencyType;
	private String orderId;
	private String status;
	private LocalDate dateOfPayment;

}
