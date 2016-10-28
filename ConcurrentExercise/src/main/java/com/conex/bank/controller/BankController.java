package com.conex.bank.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.conex.bank.dto.BaseDataOut;
import com.conex.bank.dto.IntegrationErrorCode;
import com.conex.bank.service.TransferAmountService;

@Controller
@RequestMapping(produces = { "application/json;charset=UTF-8" })
public class BankController extends BaseController {
	
	@Autowired
	private TransferAmountService transferAmountService;
	private BigDecimal amount;

	@RequestMapping("/transferAmount")
	public BaseDataOut getMovie(@RequestParam("accountNameFrom") String accountNameFrom, @RequestParam("accountNameTo") String accountNameTo, @RequestParam("amount") String amountStr) throws IOException {
		IntegrationErrorCode integrationErrorCode = validateAmount(amountStr);
		if (integrationErrorCode != null) {
			return writeErrorDataOut(integrationErrorCode);
		} else {	
			return writeSuccessDataOut(transferAmountService.transferAmount(accountNameFrom, accountNameTo, amount));
		}

	}
	
	private IntegrationErrorCode validateAmount(String amountStr) {
		try {
			amount = new BigDecimal(amountStr);
		} catch (NumberFormatException e) {
			return IntegrationErrorCode._1001;
		}
		return null;
        
    }
	
	public static void main(String[] args) {
		BigDecimal amount = new BigDecimal("sfdf");
		System.out.println(amount);
	}

}