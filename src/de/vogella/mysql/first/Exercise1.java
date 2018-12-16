package de.vogella.mysql.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PreparedStatement s = null;
		String name = "";
		Connection connect = null;
		int age = 0, salary = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=foo&password=bar");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (!name.equals("stop")) {
			System.out.println("Name of employee");
			name = scanner.next();
			if (!name.equals("stop")) {
				System.out.println("Age of employee");
				age = scanner.nextInt();
				System.out.println("Salary of employee");
				salary = scanner.nextInt();
			} else {
				try {
					connect.close();
					s.close();
					return;

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {

				s = connect.prepareStatement("insert into  feedback.employee values (?, ?, ?)");
				s.setString(1, name);
				s.setInt(2, age);
				s.setInt(3, salary);
				s.executeUpdate();
				// s.executeUpdate("create table employee (name char(30), age integer, salary
				// integer)");
				// workbench:
				// use feedback;
				// create table employee2 (name char(30), age integer, salary integer);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				scanner.close();
			}
		}
		
		try {
			s.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
