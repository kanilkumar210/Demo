package com.mindtree.bankaccountsapplication.service.service;

import java.util.List;

import com.mindtree.bankaccountsapplication.client.Application;
import com.mindtree.bankaccountsapplication.dao.ServiceCustomerDao;
import com.mindtree.bankaccountsapplication.dao.service.ServiceCustomerDaoImpl;
import com.mindtree.bankaccountsapplication.entity.Customer;
import com.mindtree.bankaccountsapplication.exception.DaoException;
import com.mindtree.bankaccountsapplication.exception.ServiceExeptioin;
import com.mindtree.bankaccountsapplication.service.ServiceCustomer;

public class ServiceCustomerImpl implements ServiceCustomer {

	ServiceCustomerDao scd = new ServiceCustomerDaoImpl();

	@Override
	public List<Customer> registerCustomers() throws ServiceExeptioin {
		List<Customer> customerList = Application.addCustomers();
		try {
			scd.saveRegisteredCustomersInDatabase(customerList);
		} catch (DaoException e) {
			throw new ServiceExeptioin("not registered");
		}
		return customerList;
	}

}
