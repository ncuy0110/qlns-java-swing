/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.Employee;
import com.qlns.model.SalaryLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalaryLogDao {

	private static final Connection conn = DBConnection.getConnection();

	public static boolean create(SalaryLog sl) {
		String sql = "insert into salary_log(employee_id, salary) values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sl.getEmployee().getId());
			ps.setLong(2, sl.getSalary());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(SalaryLogDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return false;
	}

	public static List<SalaryLog> findAll() {
		List<SalaryLog> slList = new ArrayList<>();
		String sql = "select * from salary_log";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = EmployeeDao.findOne(rs.getInt("employee_id"));
				slList.add(new SalaryLog(rs.getInt("id"), e, rs.getLong("salary"), rs.getDate("created")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(SalaryLogDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return slList;
	}

	public static List<SalaryLog> findAllByEmployee(int id) {
		List<SalaryLog> slList = new ArrayList<>();
		String sql = "select * from salary_log where employee_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = EmployeeDao.findOne(rs.getInt("employee_id"));
				slList.add(new SalaryLog(rs.getInt("id"), e, rs.getLong("salary"), rs.getDate("created")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(SalaryLogDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return slList;
	}

	public static boolean isPaid(int id) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		boolean check = false;
		for (SalaryLog sl : findAllByEmployee(id)) {
			Calendar c1 = Calendar.getInstance();
			c1.setTime(sl.getCreated());
			if (c1.get(Calendar.YEAR) == year && c1.get(Calendar.MONTH) == month) {
				check = true;
			}
		};
		return check;
	}
}
