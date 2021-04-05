package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {

		int userId = 1;

		FERService ferservice = new FERServiceImpl();
		User user = ferservice.getUser(userId);

		boolean isupdateUser = ferservice.updateuser(user);

		if (isupdateUser) {
			System.out.println("User data updated successfully");
		} else {
			System.out.println("User data update failed");
		}

	}
}