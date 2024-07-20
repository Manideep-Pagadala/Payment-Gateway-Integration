package com.alacriti.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentData {

	private String paymentRefID;
	private String merchantId;
	private Double amount;
	private String currencyType;
	private String orderId;
	private String status;
	private LocalDate dateOfPayment;

}
