package com.mindtree.bankaccountsapplication.service;

import java.util.List;

import com.mindtree.bankaccountsapplication.entity.Account;
import com.mindtree.bankaccountsapplication.exception.ServiceExeptioin;

public interface ServiceAccount {

	public List<Account> addAccountDetails() throws ServiceExeptioin;

	double updateAccountBalanceByAccountId(long accountId, double accountBal) throws ServiceExeptioin;
}
