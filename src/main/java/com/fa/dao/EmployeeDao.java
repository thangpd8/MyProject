/**
 * 
 */
package com.fa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fa.dbconnection.HibernateUtils;
import com.fa.entities.Department;
import com.fa.entities.Employee;

/**
 * @author Admin
 *
 */
public class EmployeeDao {

	public boolean addEmployee(Employee employee) {
		SessionFactory factory = null;

		try {
			factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;// TODO: handle exception
		}

	}
	
	public boolean addDepartment(Department employee) {
		SessionFactory factory = null;

		try {
			factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;// TODO: handle exception
		}

	}


	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployee() {
		SessionFactory factory = null;
		List<Employee> employees = null;
		try {
			factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			employees = (List<Employee>) session.createQuery(" from Employee").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return employees;
	}
}
