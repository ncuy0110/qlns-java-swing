/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private static final String DB_NAME = "qlns";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			String uri = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(uri, DB_USERNAME, DB_PASSWORD);
				System.out.println("Connect success!");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Connect failed!");
			}
		}
		return conn;
	}

}
