package com.conex.bank.dto;

@SuppressWarnings("serial")
public class TransferResultDto extends BaseResultOut {

	private String accountName;
	private String currentAmount;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(String currentAmount) {
		this.currentAmount = currentAmount;
	}

}
