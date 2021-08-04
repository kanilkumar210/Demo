package com.mindtree.bankaccountsapplication.service;

import java.util.List;

import com.mindtree.bankaccountsapplication.entity.Customer;
import com.mindtree.bankaccountsapplication.exception.ServiceExeptioin;

public interface ServiceCustomer {

	public List<Customer> registerCustomers() throws ServiceExeptioin;
}
