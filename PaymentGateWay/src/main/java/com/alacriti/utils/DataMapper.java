package com.alacriti.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.alacriti.entity.PaymentData;

@Component
public class DataMapper implements RowMapper<PaymentData> {
	@Override
	public PaymentData mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaymentData data = new PaymentData();
		data.setPaymentRefID(rs.getString("payment_ref_id"));
		data.setMerchantId(rs.getString("merchant_id"));
		data.setAmount(rs.getDouble("amount"));
		data.setCurrencyType(rs.getString("currency_type"));
		data.setOrderId(rs.getString("order_id"));
		data.setStatus(rs.getString("status"));
		data.setDateOfPayment(rs.getDate("date_of_payment").toLocalDate());
		return data;
	}
}
