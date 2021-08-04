package com.mindtree.bankaccountsapplication.dao;

import java.util.List;

import com.mindtree.bankaccountsapplication.entity.Customer;
import com.mindtree.bankaccountsapplication.exception.DaoException;

public interface ServiceCustomerDao {
	
	public List<Customer> saveRegisteredCustomersInDatabase(List<Customer> customers) throws DaoException;

}
