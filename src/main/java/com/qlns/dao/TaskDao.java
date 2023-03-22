/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.Employee;
import com.qlns.model.Task;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskDao {

	private static final Connection conn = DBConnection.getConnection();

	public static boolean create(Task task) {
		String sql = "insert into task(name, description, deadline, employee_id, completed) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, task.getName());
			ps.setString(2, task.getDescription());
			ps.setDate(3, (Date) task.getDeadline());
			ps.setInt(4, task.getEmployee().getId());
			ps.setBoolean(5, task.getCompleted());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(TaskDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static List<Task> findAll() {
		List<Task> tasks = new ArrayList<>();
		String sql = "select * from task";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = EmployeeDao.findOne(rs.getInt("employee_id"));
				tasks.add(new Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDate("deadline"), e, rs.getBoolean("completed"), rs.getDate("created")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(TaskDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return tasks;
	}

	public static boolean update(Task task) {
		String sql = "update task set name=?, description=?, deadline=?, employee_id=?, completed=? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, task.getName());
			ps.setString(2, task.getDescription());
			ps.setDate(3, new Date(task.getDeadline().getTime()));
			ps.setInt(4, task.getEmployee().getId());
			ps.setBoolean(5, task.getCompleted());
			ps.setInt(6, task.getId());
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(TaskDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public static boolean delete(Integer id) {
		String sql = "delete from task where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(TaskDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
}
