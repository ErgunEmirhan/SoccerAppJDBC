package com.eergun.databases;

import java.sql.DriverManager;

public class Constants {
	public static final String dbPort = "5432";
	public static final String dbHost = "localhost";
	public static final String dbUser = "postgres";
	public static final String dbPassword = "root"; //gizli
	public static final String dbName = "soccerappdb";
	public static final String dbUrl = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
	
	
}