package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetUserMain {

	public static void main(String[] args) {

		int userId = 1;
		FERService ferservice = new FERServiceImpl();
		User user = ferservice.getUser(userId);

		if (user != null) {
			System.out.println(
					user.getUserId() + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getEmail());
		}

	}

}
