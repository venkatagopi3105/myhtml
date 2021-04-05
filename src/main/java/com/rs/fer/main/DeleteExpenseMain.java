package com.rs.fer.main;


import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {
		
		// 2. Call the service for business logic execution
		FERService ferservice = new FERServiceImpl();
		boolean isdeleteExpense = ferservice.deleteExpense(2);

		// 3. Print the status
		if (isdeleteExpense) {
			System.out.println("Expense deleted successfully");
		} else {
			System.out.println("Expense deleted failed");
		}

	}
}