package com.androidgroup.dao;

import com.androidgroup.entity.User;
import com.androidgroup.util.MysqlDBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


	/*public boolean login(User user) {
		Connection conn= MysqlDBUtil.open();
		String sql = "select userid,username,password from user_t where username=? and password=?";


		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
			//stmt = conn.createStatement();
		//ResultSet rs	=stmt.(sql);
		 //System.out.println(rs.next());
			if(rs.next()){
				int id=rs.getInt(1);
				User u=new User();
			u.setId(id);
				u.setName(username);
				u.setPassword(password);
				return u;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				MysqlDBUtil.close(conn);

			}

		}
		
		return false;
	}*/


	//public List<User> findAll() {
		// TODO Auto-generated method stub
//		List<User> userList=new ArrayList<>();
//		Connection conn= MysqlDBUtil.open();
//		String sql = "select * from user_t ";
//		try {
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			ResultSet resultSet =pstmt.executeQuery();
//			while (resultSet.next()){
//				User user =new User();
//				user.setPhone_id(resultSet.getString("phone_id"));
//				user.setPass_word(resultSet.getString("pass_word"));
//				userList.add(user);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return userList;
//	}

}
