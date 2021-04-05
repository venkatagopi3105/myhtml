package com.rs.fer.main;

import java.util.Iterator;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ExpenseReportMain {

	public static void main(String[] args) {

		int userId = 2;
		String expenseType = "milk";
		String fromDate = "20-10-20";
		String toDate = "21-10-20";

		FERService ferservice = new FERServiceImpl();
		List<Expense> expenses = ferservice.expenseReport(userId, expenseType, fromDate, toDate);

		Iterator<Expense> iterator = expenses.iterator();

		Expense expense = null;
		while (iterator.hasNext()) {
			expense = iterator.next();
			if (expense != null) {
				System.out.println(expense.getExpenseId() + "," + expense.getType() + "," + expense.getTotal() + "and"
						+ expense.getBywhom());
			}
		}
	}
}
