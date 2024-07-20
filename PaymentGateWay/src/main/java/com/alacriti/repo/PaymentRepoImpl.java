package com.alacriti.repo;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alacriti.dto.PaymentRequestDTO;
import com.alacriti.dto.PaymentResponseDTO;
import com.alacriti.entity.PaymentData;
import com.alacriti.exception.DBConnectionInterruptedException;
import com.alacriti.exception.InvalidAmountException;
import com.alacriti.exception.InvalidPaymentRefIdException;
import com.alacriti.utils.DataMapper;

@Repository
public class PaymentRepoImpl implements PaymentRepo {

	@Autowired
	private JdbcTemplate jdbc;

	@Value("${queries.makePayment}")
	private String paymentSQL;

	@Value("${queries.checkStatus}")
	private String statusSQL;

	@Override
	public PaymentResponseDTO makePayment(PaymentRequestDTO dto) {

		String paymentRefId = uniqueIdGenerator();

		try {
			Double amount = dto.getAmount();

			if (amount <= 0 || amount == null) {
				throw new InvalidAmountException(" Inavlid Amount..!");
			}
			String currency = dto.getCurrencyType();
			String paymentStatus = (currency.equalsIgnoreCase("inr") || currency.equalsIgnoreCase("usd")) ? "Success"
					: "Failed";

			jdbc.update(paymentSQL, paymentRefId, dto.getMerchantId(), dto.getAmount(), dto.getCurrencyType(),
					dto.getOrderId(), paymentStatus, LocalDate.now());

			return new PaymentResponseDTO(paymentRefId, paymentStatus);

		}
		catch (DataAccessException e) {
			throw new DBConnectionInterruptedException("unexpected error, plese try again..!");
		}

	}

	@Override
	public PaymentData checkPaymentStatus(String paymentRefID) {

		if (paymentRefID.isEmpty() || paymentRefID.isBlank()) {
			throw new InvalidPaymentRefIdException(" Invalid Ref Id");
		}

		try {
			return jdbc.queryForObject(statusSQL, new DataMapper(), paymentRefID);

		} catch (EmptyResultDataAccessException e) {

			throw new InvalidPaymentRefIdException(" Invalid Ref Id");

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DBConnectionInterruptedException("unexpected error, plese try again..!");
		}
	}

	private String uniqueIdGenerator() {
		String str = UUID.randomUUID().toString().replace("-", "").substring(0, 7);
		return "ref" + str;
	}

}
