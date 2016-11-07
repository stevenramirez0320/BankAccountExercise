package com.conex.bank.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.conex.bank.dto.BaseDataOut;
import com.conex.bank.dto.IntegrationErrorCode;
import com.conex.bank.service.TransferAmountService;

@Controller
@RequestMapping(produces = { "application/json;charset=UTF-8" })
public class BankController extends BaseController {
	
	@Autowired
	private TransferAmountService transferAmountService;
	private BigDecimal transferAmt;

	@RequestMapping(value = "/transferAmount")
	@ResponseBody
	public BaseDataOut getMovie(@RequestParam("accountIdFrom") Long accountIdFrom, @RequestParam("accountIdTo") Long accountIdTo, @RequestParam("transferAmtStr") String transferAmtStr) throws IOException, InterruptedException {
		IntegrationErrorCode integrationErrorCode = validateAmount(transferAmtStr);
		if (integrationErrorCode != null) {
			return writeErrorDataOut(integrationErrorCode);
		} else {
			return writeSuccessDataOut(transferAmountService.transferAmount(accountIdFrom, accountIdTo, transferAmt));
		}
	}
	
	private IntegrationErrorCode validateAmount(String amountStr) {
		try {
			transferAmt = new BigDecimal(amountStr);
		} catch (NumberFormatException e) {
			return IntegrationErrorCode._1001;
		}
		return null;
    }
	
}