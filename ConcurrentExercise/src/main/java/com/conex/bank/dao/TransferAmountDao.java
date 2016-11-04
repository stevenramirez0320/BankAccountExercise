package com.conex.bank.dao;

import java.math.BigDecimal;

import javax.inject.Named;

import org.hibernate.Session;

import com.conex.bank.entity.BankAccount;

@Named
public class TransferAmountDao extends BaseDao{

	public synchronized BankAccount transferAmount(Long accountIdFrom, Long accountIdTo, BigDecimal amount) {
		Session session = sessionFactory.openSession();
		BankAccount  bankAccountFrom =  get(session,BankAccount.class, accountIdFrom);
		bankAccountFrom.setAmount(bankAccountFrom.getAmount().subtract(amount));
		update(session,bankAccountFrom);
		
		BankAccount  bankAccountTo =  get(session,BankAccount.class, accountIdTo);
        bankAccountTo.setAmount(bankAccountTo.getAmount().add(amount));
        update(session,bankAccountTo);
        session.flush();
        session.close();
        return bankAccountFrom;
	}
}
