package com.conex.bank.service;

import java.math.BigDecimal;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.conex.bank.dao.TransferAmountDao;
import com.conex.bank.dto.TransferResultDto;
import com.conex.bank.entity.BankAccount;

@Named
public class TransferAmountService{

	@Autowired
	private TransferAmountDao transferAmountDao;

	@Transactional(value = "transactionManager")
	public TransferResultDto transferAmount(Long accountIdFrom, Long accountIdTo, BigDecimal amount) {
		BankAccount bankAccount = transferAmountDao.transferAmount(accountIdFrom, accountIdTo, amount);
		TransferResultDto transferResultDto = new TransferResultDto();
		transferResultDto.setAccountName(bankAccount.getAccountName());
		transferResultDto.setCurrentAmount(bankAccount.getAmount().toString());
		return transferResultDto;
	}
}
