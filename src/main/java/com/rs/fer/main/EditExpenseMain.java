package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {
		Expense expense = new Expense();
		expense.setType("IceCream");
		expense.setDate("11-10-2020");
		expense.setPrice(30);
		expense.setNumberOfItems(2);
		expense.setTotal(60);
		expense.setBywhom("vamsi");
		expense.setExpenseId(1);

		// 2. Call the service for business logic execution
		FERService ferservice = new FERServiceImpl();
		boolean iseditExpense = ferservice.editExpense(expense);

		// 3. Print the status
		if (iseditExpense) {
			System.out.println("Expense edited successfully");
		} else {
			System.out.println("Expense edited failed");
		}

	}

}
