package com.conex.bank.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conex.bank.dto.TransferResultDto;

@Service
public class TransferAmountService implements Runnable {

	private TransferResultDto transferResultDto;

	@Transactional(value = "transactionManager", readOnly = true)
	public TransferResultDto transferAmount(
			String accountNameFrom, String accountNameTo, BigDecimal amount) {
		run();
		return transferResultDto;
	}

	@Override
	public void run() {
		TransferResultDto result = new TransferResultDto();
	}
}
