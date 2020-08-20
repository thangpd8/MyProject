/**
 * 
 */
package com.fa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fa.dbconnection.DBconnection;
import com.fa.entities.User;
import com.fa.utils.LogFactory;

/**
 * @author ThangPD8
 *
 */
public class UserDao {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public boolean registerUser(User user) {
		int n = 0;
		String query = "insert into Users values ( ?,?,?,?,?)";
		conn = DBconnection.getConnection();
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, user.getFirstName());
			pstm.setString(2, user.getLastName());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getUserName());
			pstm.setString(5, user.getPassword());
			n = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogFactory.getLogger().error(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LogFactory.getLogger().error(e.getMessage());
			}
		}
		if (n != 0) {
			return true;
		}
		return false;
	}
	public boolean login(User user) {
		String query = "select user_name,password from Users where user_name=? and password=?";
		conn = DBconnection.getConnection();
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getPassword());
			rs = pstm.executeQuery();
			if(rs.next()) {
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogFactory.getLogger().error(e.getMessage());
		}finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LogFactory.getLogger().error(e.getMessage());
			}
		}
		return false;
	}
}
