package com.conex.bank.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "bank_account_history")
public class BankAccountHistory implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "FROM_BANK_ACCOUNT_ID")
	private String fromBankAccountId;

	@Column(name = "TO_BANK_ACCOUNT_ID")
	private String toBankAccountId;

	@Column(name = "TRANSFERRED_AMOUNT")
	private BigDecimal amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromBankAccountId() {
		return fromBankAccountId;
	}

	public void setFromBankAccountId(String fromBankAccountId) {
		this.fromBankAccountId = fromBankAccountId;
	}

	public String getToBankAccountId() {
		return toBankAccountId;
	}

	public void setToBankAccountId(String toBankAccountId) {
		this.toBankAccountId = toBankAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
