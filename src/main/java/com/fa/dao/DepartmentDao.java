/**
 * 
 */
package com.fa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fa.dbconnection.DBconnection;
import com.fa.entities.Department;
import com.fa.utils.LogFactory;

/**
 * @author Admin
 *
 */
public class DepartmentDao {
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;

	public List<Department> findAllDepartment() {
		List<Department> list = new ArrayList<>();
		String query = "select * from Department";
		conn = DBconnection.getConnection();
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			while (rs.next()) {
				Department dep = new Department();
				dep.setDepartmentId(rs.getInt("department_id"));
				dep.setDepartmentName(rs.getString("department_name"));
				list.add(dep);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stm != null)
					stm.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LogFactory.getLogger().error(e.getMessage());
			}
		}
		
		return list;
		
	}
}
