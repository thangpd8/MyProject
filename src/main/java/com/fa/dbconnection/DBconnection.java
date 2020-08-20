/**
 * 
 */
package com.fa.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fa.utils.LogFactory;

/**
 * @author ThangPD8
 *
 */
public class DBconnection {
	public static Connection getConnection() {
		Connection conn = null;
		String user = "sa";
		String password = "fresher@12345";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=HR_DB_LAB;", user,
					password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			LogFactory.getLogger().error(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogFactory.getLogger().error(e.getMessage());
		}
		return conn;
	}
}
