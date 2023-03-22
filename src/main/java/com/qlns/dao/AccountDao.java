/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.qlns.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDao {

	private static final Connection conn = DBConnection.getConnection();

	public static Account login(String username, String password) {
		String sql = "select * from admin where username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next() && rs.getString("password").equals(password)) {
				return new Account(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
