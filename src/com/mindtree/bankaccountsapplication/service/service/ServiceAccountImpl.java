package com.mindtree.bankaccountsapplication.service.service;

import java.util.List;

import com.mindtree.bankaccountsapplication.client.Application;
import com.mindtree.bankaccountsapplication.dao.ServiceAccountDao;
import com.mindtree.bankaccountsapplication.dao.service.ServiceAccountDaoImpl;
import com.mindtree.bankaccountsapplication.entity.Account;
import com.mindtree.bankaccountsapplication.exception.DaoException;
import com.mindtree.bankaccountsapplication.exception.ServiceExeptioin;
import com.mindtree.bankaccountsapplication.exception.service.IdNotFoundException;
import com.mindtree.bankaccountsapplication.service.ServiceAccount;

public class ServiceAccountImpl implements ServiceAccount {
	ServiceAccountDao sadObj = new ServiceAccountDaoImpl();

	@Override
	public List<Account> addAccountDetails() throws ServiceExeptioin {
		List<Account> accountList = Application.insertTheAccountDetails();
		try {
			sadObj.saveAccountDetailsInDatabase(accountList);
		} catch (DaoException e) {
			throw new IdNotFoundException("Invalid Customer Id");
		}
		return accountList;
	}

	@Override
	public double updateAccountBalanceByAccountId(long accountId, double accountBal) throws ServiceExeptioin {
		try {
			sadObj.updateTheAccountBalance(accountId, accountBal);
		} catch (DaoException e) {
			throw new IdNotFoundException("Invalid Account Id");
		}
		return accountBal;
	}

}
