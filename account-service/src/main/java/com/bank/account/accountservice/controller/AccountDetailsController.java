package com.bank.account.accountservice.controller;

import java.util.List;

import com.bank.account.accountservice.model.Account;
import com.bank.account.accountservice.model.Transaction;

public interface AccountDetailsController {

	/**
	 * For the resource health check.
	 * 
	 * @return
	 */
	public String healthCheck();

	/**
	 * Returns the list of accounts for a given customer party sys id.
	 * 
	 * @param partySysId
	 * @return
	 */
	public List<Account> retrieveAccounts(Long partySysId);

	/**
	 * Returns all the Transactions for a given account number.
	 * 
	 * @author Arindam Bhaumik
	 * @since 28-APR-2019
	 * @param accountID
	 * @return
	 */
	public List<Transaction> retrieveTransactions(int accountID);
}
