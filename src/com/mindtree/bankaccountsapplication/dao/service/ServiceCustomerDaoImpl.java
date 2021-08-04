package com.mindtree.bankaccountsapplication.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mindtree.bankaccountsapplication.dao.ServiceCustomerDao;
import com.mindtree.bankaccountsapplication.entity.Customer;
import com.mindtree.bankaccountsapplication.exception.DaoException;
import com.mindtree.bankaccountsapplication.exception.UtilityException;
import com.mindtree.bankaccountsapplication.utility.DatabaseConnection;

public class ServiceCustomerDaoImpl implements ServiceCustomerDao {

	@Override
	public List<Customer> saveRegisteredCustomersInDatabase(List<Customer> customers) throws DaoException {
		Connection connection = null;
		connection = DatabaseConnection.DatabaseConnection();
		PreparedStatement statement = null;
		try {
			String sql = "insert into customer values(?,?,?)";
			for (int i = 0; i < customers.size(); i++) {
				try {
					statement = connection.prepareStatement(sql);
					statement.setLong(1, customers.get(i).getCustId());
					statement.setString(2, customers.get(i).getCustName());
					statement.setLong(3, customers.get(i).getCustAdhar());
					statement.executeUpdate();
				} catch (SQLException e) {
					throw new DaoException("SQL syntax Error");
				}
			}
		} catch (UtilityException e) {
			throw new DaoException("Connection not Found Exception");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new DaoException("Close the Resources");
			}
		}
		return customers;
	}
	
	

}
