package com.androidgroup.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlDBUtil {

	public static String driver="com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://localhost_3306/headline";
	public static String username="root";
	public static String password="123456";

	/*
	  ***数据库连接***
    */
	public static Connection open(){
		try {
			Class.forName(driver);
			try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	  ***数据库关闭***
    */
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
