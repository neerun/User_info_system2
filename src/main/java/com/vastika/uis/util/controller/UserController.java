package com.vastika.uis.util.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.vastika.uis.util.model.User;
import com.vastika.uis.util.service.UserService;
import com.vastika.uis.util.service.UserServiceImpl;

public class UserController {
	

	public static void main(String[] args) {

		UserService userService = new UserServiceImpl();
		String decision = "";
		do {
			String choice = JOptionPane.showInputDialog("Enter your choice save|update|delete|list|get");

			switch (choice) {
			case "save":
				User user = getUser();

				int saved = userService.saveUserInfo(user);
				if (saved >= 1) {
					JOptionPane.showInternalMessageDialog(null, "user info is saved successfully");
				} else {
					JOptionPane.showMessageDialog(null, "error in code");
				}
				break;

			case "update":
				User updatedUser = getUser();

				int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
				updatedUser.setId(id);

				int updated = userService.updateUserInfo(updatedUser);
				if (updated >= 1) {
					JOptionPane.showInternalMessageDialog(null, "user info is updated  successfully");
				} else {
					JOptionPane.showMessageDialog(null, "error in code");
				}
				break;
			case "delete":

				id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));

				int delete = userService.deleteUserInfo(id);
				if (delete >= 1) {
					JOptionPane.showInternalMessageDialog(null, "user info is deleted  successfully");
				} else {
					JOptionPane.showMessageDialog(null, "error in code");
				}
				break;

			case "list":
				List<User> userList = userService.getAllUserInfo();
				for (User u : userList) {
					System.out.println("User id is :" + u.getId());
					System.out.println("user name is: " + u.getUsername());
					System.out.println("password is:" + u.getPassword());
					System.out.println("salary is:" + u.getSalary());
					System.out.println("Is_active is:" + u.isActive());
					System.out.println("mobileNo is:" + u.getMobileNo());
					System.out.println("============================");

				}
				break;

			case "get":

				id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID"));
				User u = userService.getUserById(id);
				System.out.println("User id is :" + u.getId());
				System.out.println("user name is: " + u.getUsername());
				System.out.println("password is:" + u.getPassword());
				System.out.println("salary is:" + u.getSalary());
				System.out.println("Is_active is:" + u.isActive());
				System.out.println("mobileNo is:" + u.getMobileNo());
				System.out.println("============================");

				break;

			default:
				JOptionPane.showMessageDialog(null, "wrong choice");
				break;

			}
			decision = JOptionPane.showInputDialog("Do u want to perform next code? Enter Yes or No");
		} while (decision.equalsIgnoreCase("yes"));
		JOptionPane.showMessageDialog(null, "By by Happy coding , see u again hai ta ");

	}

	public static User getUser() {

		User user = new User();
		String userName = JOptionPane.showInputDialog("Enter username");
		String password = JOptionPane.showInputDialog("Enter password");
		long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile no"));
		double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary"));
		boolean isActive = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter isActive"));
		user.setUsername(userName);
		user.setPassword(password);
		user.setMobileNo(mobileNo);
		user.setSalary(salary);
		user.setActive(isActive);

		return user;
	}

}