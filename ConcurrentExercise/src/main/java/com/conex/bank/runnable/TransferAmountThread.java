package com.conex.bank.runnable;

import java.math.BigDecimal;

import com.conex.bank.dto.TransferResultDto;
import com.conex.bank.service.TransferAmountService;

public class TransferAmountThread extends Thread {
	
	private volatile TransferResultDto transferResultDto;
	private TransferAmountService transferAmountService;
	private Long accountIdFrom;
	private Long accountIdTo;
	private BigDecimal amount;

	@Override
	public void run() {
		setTransferResultDto(transferAmountService.transferAmount(accountIdFrom, accountIdTo, amount));
	}

	public TransferAmountThread(Long accountIdFrom, Long accountIdTo, BigDecimal amount, TransferAmountService transferAmountService) {
		this.transferAmountService = transferAmountService;
		this.accountIdFrom = accountIdFrom;
		this.accountIdTo = accountIdTo;
		this.amount = amount;
	}

	public TransferResultDto getTransferResultDto() {
		return transferResultDto;
	}

	public void setTransferResultDto(TransferResultDto transferResultDto) {
		this.transferResultDto = transferResultDto;
	}

}
