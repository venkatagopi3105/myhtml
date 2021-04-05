package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {

		// 1.Load the input

		// 2. Call the service for business logic execution
		FERService ferservice = new FERServiceImpl();
		boolean isLogin = ferservice.login("Rudra", "9999");

		// 3. Print the status
		if (isLogin) {
			System.out.println("User is Valid");
		} else {
			System.out.println("User is not Valid");
		}
	}
}