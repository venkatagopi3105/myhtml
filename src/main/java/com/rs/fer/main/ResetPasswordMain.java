package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {


		@SuppressWarnings("unused")
		User user = new User();

		// 2. Call the service for business logic execution
		FERService ferservice = new FERServiceImpl();
		boolean isresetPassword = ferservice.resetPassword(1, "9999", "3699");

		// 3. Print the status
		if (isresetPassword) {
			System.out.println("Password reset successfully");
		} else {
			System.out.println("Password reset failed");
		}

	}

}
