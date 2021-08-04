package com.mindtree.bankaccountsapplication.entity;

public class Customer {
	private long custId;
	private String custName;
	private long custAdhar;

	public Customer() {
		super();
	}

	public Customer(long custId) {
		super();
		this.custId = custId;
	}

	public Customer(long custId, String custName, long custAdhar) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAdhar = custAdhar;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public long getCustAdhar() {
		return custAdhar;
	}

	public void setCustAdhar(long custAdhar) {
		this.custAdhar = custAdhar;
	}

}
