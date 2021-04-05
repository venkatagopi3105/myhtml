package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {

		int expenseId = 1;

		FERService ferservice = new FERServiceImpl();
		Expense expense = ferservice.getExpense(expenseId);

		if (expense != null) {
			System.out.println(expense.getExpenseId() + "," + expense.getTotal() + "and" + expense.getBywhom());
		}

	}
}
