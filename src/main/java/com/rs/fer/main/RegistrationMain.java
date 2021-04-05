package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		// 1.Load the input
		User user = new User();
		user.setFirstName("Vamsi");
		user.setMiddleName("Chowdary");
		user.setLastName("Bollineni");
		user.setEmail("vamsi3699@email.com");
		user.setUserName("Rudra");
		user.setPassword("9999");
		user.setMobile("99999999");

		// 2. Call the service for business logic execution
		FERService ferservice = new FERServiceImpl();
		boolean isRegister = ferservice.registration(user);

		// 3. Print the status
		if (isRegister) {
			System.out.println("user registration is successfull");
		} else {
			System.out.println("user registration is failed");
		}
	}
}
