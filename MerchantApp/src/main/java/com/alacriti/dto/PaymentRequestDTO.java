package com.alacriti.dto;

import com.alacriti.exception.InvalidAmountException;

import lombok.Data;

@Data
public class PaymentRequestDTO {

	private String merchantId;
	private Double amount;
	private String currencyType;
	private String orderId;

	public void setAmount(Object amount) {

		if (amount instanceof Double)
			this.amount = (Double) amount;
		else if ((amount instanceof Integer))
			this.amount = Double.valueOf((Integer) amount);
		else
			throw new InvalidAmountException("Invalid Amount Format..!");

	}

}
