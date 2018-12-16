package de.vogella.mysql.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test h = new Test();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost/feedback?" + "user=foo&password=bar");) {

			h.insertBook(connect);
			System.out.println(h.getTitle("Janne Andersson", connect));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertBook(Connection connect) {
		try (PreparedStatement s = connect.prepareStatement("insert into  feedback.books5 values (default,?, ?, ?)");) {

			s.setString(1, "Tapeter och solsken");
			s.setString(2, "Janne Andersson");
			s.setInt(3, 876);
			s.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getTitle(String author, Connection connect) {
		String title = null;
		try (Statement statement = connect.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select * from feedback.books4 where author ='" + author + "';");) {

			while (resultSet.next()) {

				title = resultSet.getString("title");

			}

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return title;

	}

}
