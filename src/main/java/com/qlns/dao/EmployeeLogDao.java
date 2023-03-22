/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.Employee;
import com.qlns.model.EmployeeLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeLogDao {

	private static final Connection conn = DBConnection.getConnection();

	public static boolean create(EmployeeLog el) {
		String sql = "insert into employee_log(employee_id, reward, amount, reason) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, el.getEmployee().getId());
			ps.setBoolean(2, el.getReward());
			ps.setLong(3, el.getAmount());
			ps.setString(4, el.getReason());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeLogDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return false;
	}

	public static List<EmployeeLog> findAll() {
		List<EmployeeLog> elList = new ArrayList<>();
		String sql = "select * from employee_log";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = EmployeeDao.findOne(rs.getInt("employee_id"));
				elList.add(new EmployeeLog(rs.getInt("id"), e, rs.getBoolean("reward"), rs.getLong("amount"), rs.getString("reason"), rs.getDate("created")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeLogDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return elList;
	}

	public static List<EmployeeLog> findAllByEmployee(int id) {
		List<EmployeeLog> elList = new ArrayList<>();
		String sql = "select * from employee_log where employee_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = EmployeeDao.findOne(rs.getInt("employee_id"));
				elList.add(new EmployeeLog(rs.getInt("id"), e, rs.getBoolean("reward"), rs.getLong("amount"), rs.getString("reason"), rs.getDate("created")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeLogDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return elList;
	}

	public static List<EmployeeLog> findInMonthOfEmployee(int employeeId) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR), month = c.get(Calendar.MONTH);
		List<EmployeeLog> elList = new ArrayList<>();
		for (EmployeeLog el : findAllByEmployee(employeeId)) {
			c.setTime(el.getCreated());
			if (year == c.get(Calendar.YEAR) && month == c.get(Calendar.MONTH)) {
				elList.add(el);
			}
		}
		return elList;
	}

	public static EmployeeLog findOne(int id) {
		String sql = "select * from employee_log where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = EmployeeDao.findOne(rs.getInt("employee_id"));
				return new EmployeeLog(rs.getInt("id"), e, rs.getBoolean("reward"), rs.getLong("amount"), rs.getString("reason"), rs.getDate("created"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeLogDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public static boolean update(EmployeeLog el) {
		String sql = "update employee_log set employee_id=?, reward=?, amount=?, reason=? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, el.getEmployee().getId());
			ps.setBoolean(2, el.getReward());
			ps.setLong(3, el.getAmount());
			ps.setString(4, el.getReason());
			ps.setInt(5, el.getId());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeLogDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static boolean delete(Integer id) {
		String sql = "delete from employee_log where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(EmployeeLogDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
}
