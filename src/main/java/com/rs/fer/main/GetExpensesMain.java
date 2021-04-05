package com.rs.fer.main;

import java.util.Iterator;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {

		int userId = 2;

		FERService ferservice = new FERServiceImpl();
		List<Expense> expenses = ferservice.getExpenses(userId);

		Iterator<Expense> iterator = expenses.iterator();

		Expense expense = null;
		while (iterator.hasNext()) {
			expense = iterator.next();
			if (expense != null) {
				System.out.println(expense.getUserId() + "," + expense.getType() + "," + expense.getTotal() + "and"
						+ expense.getBywhom());
			}
		}
	}

}
