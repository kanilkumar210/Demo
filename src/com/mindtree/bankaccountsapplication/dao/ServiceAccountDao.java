package com.mindtree.bankaccountsapplication.dao;

import java.util.List;

import com.mindtree.bankaccountsapplication.entity.Account;
import com.mindtree.bankaccountsapplication.exception.DaoException;

public interface ServiceAccountDao {
	public List<Account> saveAccountDetailsInDatabase(List<Account> account) throws DaoException;

	public double updateTheAccountBalance(long accountId, double accountBal) throws DaoException;

}
