/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDao {

	private static final Connection conn = DBConnection.getConnection();

	public static boolean create(Employee emp) {
		String sql = "insert into employee(first_name, last_name, phone_number, address, salary, gender) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getPhoneNumber());
			ps.setString(4, emp.getAddress());
			ps.setLong(5, emp.getSalary());
			ps.setBoolean(6, emp.getGender());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static Employee findOne(int id) {
		String sql = "select * from employee where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Employee(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("phone_number"),
					rs.getString("address"),
					rs.getLong("salary"),
					rs.getBoolean("gender")
				);
			}
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public static List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		String sql = "select * from employee";
		try {
			Statement stt = conn.createStatement();
			ResultSet rs = stt.executeQuery(sql);
			while (rs.next()) {
				employees.add(new Employee(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("phone_number"),
					rs.getString("address"),
					rs.getLong("salary"),
					rs.getBoolean("gender")
				));
			}
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return employees;
	}

	public static List<Employee> findByName(String name) {
		List<Employee> employees = new ArrayList<>();
		String sql = "select * from employee where first_name like ? or last_name like ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ps.setString(2, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("phone_number"),
					rs.getString("address"),
					rs.getLong("salary"),
					rs.getBoolean("gender")
				));
			}
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return employees;
	}

	public static boolean update(Employee emp) {
		String sql = "update employee set first_name=?, last_name=?, phone_number=?, address=?, salary=?, gender=? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getPhoneNumber());
			ps.setString(4, emp.getAddress());
			ps.setLong(5, emp.getSalary());
			ps.setBoolean(6, emp.getGender());
			ps.setInt(7, emp.getId());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static boolean delete(Integer id) {
		String sql = "delete from employee where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
}
