package com.mindtree.bankaccountsapplication.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.bankaccountsapplication.entity.Account;
import com.mindtree.bankaccountsapplication.entity.Customer;
import com.mindtree.bankaccountsapplication.exception.ApplicationException;
import com.mindtree.bankaccountsapplication.service.ServiceAccount;
import com.mindtree.bankaccountsapplication.service.ServiceCustomer;
import com.mindtree.bankaccountsapplication.service.service.ServiceAccountImpl;
import com.mindtree.bankaccountsapplication.service.service.ServiceCustomerImpl;

public class Application {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ApplicationException {
		byte choice = 0;
		ServiceCustomer scObj = new ServiceCustomerImpl();
		ServiceAccount saObj = new ServiceAccountImpl();
		do {
			System.out.println("1 :register Customers");
			System.out.println("2 :add Account details");
			System.out.println("3 :update balance");
			choice = sc.nextByte();
			switch (choice) {
			case 1:
				scObj.registerCustomers();
				break;
			case 2:
				saObj.addAccountDetails();
				break;
			case 3:
				System.out.println("Enter the Account id");
				long accountId = sc.nextLong();
				System.out.println("Enter the new Balance");
				double accountBal = sc.nextDouble();
				saObj.updateAccountBalanceByAccountId(accountId, accountBal);
				break;
			}
		} while (choice >= 1);
	}

	public static List<Customer> addCustomers() {
		System.out.println("Enter the number of customers to add");
		int noOfCust = sc.nextInt();
		List<Customer> customerList = new ArrayList<Customer>();
		for (int index = 0; index < noOfCust; index++) {
			Customer customerObj = new Customer();
			System.out.println("Enter the Customer Id");
			long custId = sc.nextLong();
			System.out.println("Enter the Customer Name");
			sc.nextLine();
			String custName = sc.nextLine();
			System.out.println("Enter the Aadhar Number");
			long custAdhar = sc.nextLong();
			customerObj = new Customer(custId, custName, custAdhar);
			customerList.add(customerObj);
		}
		return customerList;
	}

	public static List<Account> insertTheAccountDetails() {
		System.out.println("Enter the number of Accounts Details to add");
		int noOfAccounts = sc.nextInt();
		List<Account> accountList = new ArrayList<Account>();
		for (int i = 0; i < noOfAccounts; i++) {
			Customer cust = new Customer();
			Account account = new Account();
			System.out.println("Enter the Customer Id");
			long custId = sc.nextLong();
			System.out.println("Enter the Account Id");
			long accountId = sc.nextLong();
			System.out.println("Enter the Account Type");
			sc.nextLine();
			String accountType = sc.nextLine();
			System.out.println("Enter the Account Balance");
			double accountBal = sc.nextDouble();
			cust = new Customer(custId);
			account = new Account(cust, accountId, accountType, accountBal);
			accountList.add(account);
		}
		return accountList;
	}

}
