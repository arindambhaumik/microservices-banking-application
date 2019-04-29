package com.bank.account.accountservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Arindam Bhaumik
 *
 */
@Entity
@Table(name = "account_transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transaction_id;

	@Column(name = "account_id")
	private int accountId;

	@Column(name = "Transaction_Reference")
	private String transactionReference;

	@Column(name = "Type")
	private String type;

	@Column(name = "Amount")
	private int amount;

	/**
	 * @return the transaction_id
	 */
	public Long getTransaction_id() {
		return transaction_id;
	}

	/**
	 * Default constructor
	 */
	public Transaction() {
		super();
	}

	public Transaction(Long transaction_id, int accountId, String transactionReference, String type, int amount) {
		super();
		this.transaction_id = transaction_id;
		this.accountId = accountId;
		this.transactionReference = transactionReference;
		this.type = type;
		this.amount = amount;
	}

	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(Long transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the transactionReference
	 */
	public String getTransactionReference() {
		return transactionReference;
	}

	/**
	 * @param transactionReference the transactionReference to set
	 */
	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
