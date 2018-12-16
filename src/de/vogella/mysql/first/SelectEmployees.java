package de.vogella.mysql.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean printNo = true;
		String nameFromUser = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Scanner scanner = new Scanner(System.in);
				Connection connect = DriverManager
						.getConnection("jdbc:mysql://localhost/feedback?" + "user=foo&password=bar");
				Statement statement = connect.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select * from feedback.employee where name ='" + nameFromUser + "';");) {

			nameFromUser = scanner.next();

			while (resultSet.next()) {
				printNo = false;
				int salary = resultSet.getInt("salary");
				int age = resultSet.getInt("age");
				System.out.println(nameFromUser + " earns " + salary + " $ and is " + age + " years old. ");
			}
			if (printNo)
				System.out.println(nameFromUser + " was not found. ");

			// scanner.close();
			// connect.close();
			statement.close();
			resultSet.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
