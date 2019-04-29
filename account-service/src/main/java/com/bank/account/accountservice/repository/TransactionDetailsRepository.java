/**
 * 
 */
package com.bank.account.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.account.accountservice.model.Transaction;

/**
 * @author Arindam Bhaumik
 *
 */
public interface TransactionDetailsRepository extends JpaRepository<Transaction, Integer> {
	 public List<Transaction> findByAccountId(int account_id);
}
