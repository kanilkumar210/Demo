package com.mindtree.bankaccountsapplication.entity;

public class Account {

	private Customer customer;
	private long accountId;
	private String accountType;
	private double accountBal;

	public Account(Customer customer, long accountId, String accountType, double accountBal) {
		super();
		this.customer = customer;
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBal = accountBal;
	}

	public Account(long accountId, String accountType, double accountBal) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBal = accountBal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Account() {
		super();
	}

	public double getAccountBal() {
		return accountBal;
	}

	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}

}
