package com.alacriti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponseDTO {

	private String paymentRefID;
	private String status;
}
