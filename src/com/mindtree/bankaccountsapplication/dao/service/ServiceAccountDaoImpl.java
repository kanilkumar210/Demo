package com.mindtree.bankaccountsapplication.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mindtree.bankaccountsapplication.dao.ServiceAccountDao;
import com.mindtree.bankaccountsapplication.entity.Account;
import com.mindtree.bankaccountsapplication.exception.DaoException;
import com.mindtree.bankaccountsapplication.exception.UtilityException;
import com.mindtree.bankaccountsapplication.utility.DatabaseConnection;

public class ServiceAccountDaoImpl implements ServiceAccountDao {

	@Override
	public List<Account> saveAccountDetailsInDatabase(List<Account> account) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			connection = DatabaseConnection.DatabaseConnection();
			for (int i = 0; i < account.size(); i++) {
				String sql1 = "select * from customer where customer_id=" + account.get(i).getCustomer().getCustId();
				try {
					statement = connection.prepareStatement(sql1);
					resultset = statement.executeQuery();
					if (resultset.next()) {
						String sql2 = "insert into accountdetails values(?,?,?,?)";
						statement = connection.prepareStatement(sql2);
						statement.setLong(1, account.get(i).getCustomer().getCustId());
						statement.setLong(2, account.get(i).getAccountId());
						statement.setString(3, account.get(i).getAccountType());
						statement.setDouble(4, account.get(i).getAccountBal());
						statement.executeUpdate();
					}
				} catch (SQLException e) {
					throw new DaoException("SQL syntax error");
				}

			}
		} catch (UtilityException e) {
			throw new DaoException("connection not found");
		} finally {
			try {
				resultset.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new DaoException("Close the Resourses");
			}

		}
		return account;
	}

	@Override
	public double updateTheAccountBalance(long accountId, double accountBal) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;

		connection = DatabaseConnection.DatabaseConnection();
		String str = "select * from accountdetails where account_Id=" + accountId;
		try {
			statement = connection.prepareStatement(str);
			resultset = statement.executeQuery();
			if (resultset.next()) {
				String sql = "update accountdetails set account_balance=" + accountBal + " where account_id="
						+ accountId;
				statement = connection.prepareStatement(sql);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DaoException("SQL Syntax Exception");
		}

		return accountBal;
	}
}
