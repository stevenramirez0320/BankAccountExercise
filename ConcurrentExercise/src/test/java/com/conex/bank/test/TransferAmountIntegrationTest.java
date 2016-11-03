package com.conex.bank.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.conex.bank.dto.TransferResultDto;
import com.conex.bank.runnable.TransferAmountThread;
import com.conex.bank.service.TransferAmountService;


public class TransferAmountIntegrationTest extends BaseTestCase{

	@Autowired
	private TransferAmountService transferAmountService;
	private static final Long ACCOUNT_ID_FROM = 1L;
	private static final Long ACCOUNT_ID_TO = 2L;
	private static final BigDecimal TRANSFER_AMT = new BigDecimal(2);
	private static final BigDecimal EXPECTED_CURRENT_AMT = new BigDecimal(9980);
	
	/**
	 * The amount for each account should be 10,000 for the assert to work properly
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testTransferAmount() throws InterruptedException {
		TransferAmountThread transferAmountThread = new TransferAmountThread(ACCOUNT_ID_FROM, ACCOUNT_ID_TO, TRANSFER_AMT, transferAmountService);
		for (int i = 0; i < 1; i++) {
			transferAmountThread.start();
		}
		transferAmountThread.join();
		TransferResultDto transferResultDto = transferAmountThread.getTransferResultDto();
		BigDecimal currentAmount = new BigDecimal(transferResultDto.getCurrentAmount());
		Assert.assertTrue(currentAmount.compareTo(EXPECTED_CURRENT_AMT) == 0);
	}
}
