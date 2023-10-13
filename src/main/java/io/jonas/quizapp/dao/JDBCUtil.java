package io.jonas.quizapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class JDBCUtil {
	private static final String url = "jdbc:mysql://localhost:3306/teluskodb?useSSL=false";
	private static final String username = "root";
	private static final String password = "password";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

// get the connection using the DriverMager
	public static Connection getDbConnection() throws SQLSyntaxErrorException,SQLException {

		return DriverManager.getConnection(url, username, password);

	}

	// close the resources
	public static void closeResources(ResultSet rs, Statement st, Connection connection) throws SQLException {
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (connection != null)
			connection.close();
	}

	public static void closeResources(Statement st, Connection connection) throws SQLException {
		if (st != null)
			st.close();
		if (connection != null)
			connection.close();
	}

}
