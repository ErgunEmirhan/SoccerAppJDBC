package com.eergun.databases;

import com.eergun.utility.Constants;

import java.sql.*;
import java.util.Optional;

public class DatabaseHelper {
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	private static DatabaseHelper dbHelper = new DatabaseHelper();
	
	public static DatabaseHelper getInstance(){
		return dbHelper;
	}
	
	private DatabaseHelper(){}
	
	private boolean connect() {
		try {
			conn =
					DriverManager.getConnection(Constants.dbUrl, Constants.dbUser,
					                            Constants.dbPassword);
			return true;
		}
		catch (SQLException e) {
			System.out.println("Baglanti kurulamadi..." + e.getMessage());
			return false;
		}
	}
	
	public void executeUpdate(String sql) throws SQLException {
		if (connect()){
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
			disconnect();
		}
	}
	
	public Optional<ResultSet> executeQuery(String sql) throws SQLException {
		if (connect()){
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			disconnect();
			return Optional.ofNullable(rs);
		}
		else return Optional.empty();
	}
	
	private void disconnect(){
		try {
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}