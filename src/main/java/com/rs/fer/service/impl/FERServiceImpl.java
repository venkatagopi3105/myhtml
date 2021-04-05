package com.rs.fer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.DBUtil;
import com.rs.fer.util.HibernateUtil;

public class FERServiceImpl implements FERService {

	

	public boolean login(String username, String password) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();

		Query query = session.createQuery("Select u from User u where u.userName=? and u.password=?");

		query.setString(0, username);
		query.setString(1, password);
		@SuppressWarnings("unchecked")
		List<User> users = query.list();

		Iterator<User> iterator = users.iterator();

		@SuppressWarnings("unused")
		User user = null;
		while (iterator.hasNext()) {
			user = iterator.next();
			return true;
		}
		return false;
	}

	public boolean addExpense(Expense expense) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		expense.getType();
		expense.getDate();
		expense.getPrice();
		expense.getNumberOfItems();
		expense.getTotal();
		expense.getBywhom();

		session.save(expense);
		transaction.commit();
		return true;

	}

	public boolean editExpense(Expense expense) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		expense.getType();
		expense.getDate();
		expense.getPrice();
		expense.getNumberOfItems();
		expense.getTotal();
		expense.getBywhom();
		expense.getExpenseId();

		session.update(expense);
		transaction.commit();
		return true;

	}

	public boolean deleteExpense(int expenseId) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("Delete from Expense E where E.ExpenseId=? ");

		query.setParameter(0, expenseId);

		int numOfRecAffected = query.executeUpdate();
		transaction.commit();

		if (numOfRecAffected > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("Update User U Set U.password=? where U.userId=?");

		query.setParameter(0, newPassword);
		query.setParameter(1, userId);

		int numofRecAffected = query.executeUpdate();

		transaction.commit();

		if (numofRecAffected > 0) {
			return true;
		} else {
			return false;
		}

	}

	public Expense getExpense(int expenseId) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("ExpenseId", expenseId));
		@SuppressWarnings("unchecked")
		List<Expense> users = criteria.list();
		Iterator<Expense> iterator = users.iterator();

		Expense expense = null;
		while (iterator.hasNext()) {
			expense = iterator.next();
			return expense;
		}

		return expense;
	}

	public List<Expense> getExpenses(int userId) {
		List<Expense> expenses = new ArrayList<Expense>();
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("userId", userId));
		@SuppressWarnings("unchecked")
		List<Expense> users = criteria.list();
		Iterator<Expense> iterator = users.iterator();

		@SuppressWarnings("unused")
		Expense expense = null;
		while (iterator.hasNext()) {
			expense = iterator.next();
			expenses.add(expense);
			return expenses;
		}
		return expenses;
	}

	public List<Expense> expenseReport(int userId, String expenseType, String fromDate, String toDate) {
		List<Expense> expenses = new ArrayList<Expense>();
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("type", expenseType));
		criteria.add(Restrictions.eq("date", fromDate));
		criteria.add(Restrictions.eq("date", toDate));
		
		List<Expense> users = criteria.list();
		Iterator<Expense> iterator = users.iterator();

		Expense expense = null;
		while (iterator.hasNext()) {
			expense = iterator.next();
			expenses.add(expense);
			return expenses;
		}
		return expenses;
	}

	public User getUser(int userId) {
		User user = null;
		Address address = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isvalidUser = false;
		try {
			connection = DBUtil.getConnection();
			String inputSQL = "select u.*,a.* from user u left join address a on u.user_id=a.user_id where u.user_id=?";
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt(1));
				user.setFirstName(resultSet.getString(2));
				user.setMiddleName(resultSet.getString(3));
				user.setLastName(resultSet.getString(4));
				user.setEmail(resultSet.getString(5));
				user.setUserName(resultSet.getString(6));
				user.setPassword(resultSet.getString(7));
				user.setMobile(resultSet.getString(8));

				address = new Address();
				address.setAddressId(resultSet.getInt(9));
				address.setLineOne(resultSet.getString(10));
				address.setLineTwo(resultSet.getString(11));
				address.setCity(resultSet.getString(12));
				address.setState(resultSet.getString(13));
				address.setPinCode(resultSet.getString(14));
				address.setCountry(resultSet.getString(15));
				address.setAddressId(resultSet.getInt(16));

				user.setAddress(address);

				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return null;
	}

	public boolean updateuser(User user) {
		int num1 = 0;
		int numOfRecAff = 0;
		boolean isupdate = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
			// update user
			String inputSQL = "update user set firstname=?,middlename=?,lastname=?,email=?,mobileno=? where user_id=?";
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMiddleName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getMobile());
			preparedStatement.setInt(6, user.getUserId());

			int numofRecAff = preparedStatement.executeUpdate();

			Address address = user.getAddress();
			int addressId = user.getAddress().getAddressid();
			boolean isAdd = (addressId > 0);
			// update address
			inputSQL = (isAdd)
					? "update address set line1=?,line2=?,city=?,state=?,pincode=?,country=? where address_id=?"
					: "insert into address(line1,line2,city,state,pincode,country,user_id) values(?,?,?,?,?,?,?)";

			// set
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setString(1, address.getLineOne());
			preparedStatement.setString(2, address.getLineTwo());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getState());
			preparedStatement.setString(5, address.getPinCode());
			preparedStatement.setString(6, address.getCountry());

			if (isAdd) {
				preparedStatement.setInt(7, address.getAddressId());

			} else {
				preparedStatement.setInt(7, user.getUserId());

			}
			num1 = preparedStatement.executeUpdate();
			isupdate = (num1 >= 1);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isupdate;
	}

	public boolean registration(User user) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		return true;
	}

}