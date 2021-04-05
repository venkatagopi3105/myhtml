package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {
		Expense expense = new Expense();
		expense.setType("sweets");
		expense.setDate("29/10/2020");
		expense.setPrice(20);
		expense.setNumberOfItems(6);
		expense.setTotal(120);
		expense.setBywhom("vamsi");
		expense.setExpenseId(1);

		// 2. Call the service for business logic execution
		FERService ferservice = new FERServiceImpl();
		boolean isaddExpense = ferservice.addExpense(expense);

		// 3. Print the status
		if (isaddExpense) {
			System.out.println("Expense added successfully");
		} else {
			System.out.println("Expense added failed");
		}

	}

}