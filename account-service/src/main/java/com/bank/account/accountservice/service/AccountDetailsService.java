package com.bank.account.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.accountservice.model.Account;
import com.bank.account.accountservice.model.Transaction;
import com.bank.account.accountservice.repository.AccountDetailsRepository;
import com.bank.account.accountservice.repository.TransactionDetailsRepository;

@Service
public class AccountDetailsService {
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;

	public List<Account> retrieveAccounts(Long partySysId) {
		return accountDetailsRepository.findByPartysysid(partySysId);
	}

	/**
	 * 
	 * @author Arindam Bhaumik
	 * @param accountID
	 * @return
	 * 
	 */
	public List<Transaction> retrieveTransactions(int accountID) {
		return transactionDetailsRepository.findByAccountId(accountID);
	}
}
