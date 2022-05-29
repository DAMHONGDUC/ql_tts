package com.example.pv.hanbiro.ql_tts.Repository;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pv.hanbiro.ql_tts.Model.User;
import com.example.pv.hanbiro.ql_tts.db.DBConst;
import com.example.pv.hanbiro.ql_tts.db.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class UserRepositoryImpl implements UserRepository {
	private List<User> users;
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;
	
	UserRepositoryImpl()
	{
//		users = new ArrayList<>();
//		users.add(new User(1, "tendangnhap1", "matkhau1", "ten1", "email1", "sdt1" ));
//		users.add(new User(2, "tendangnhap2", "matkhau2", "ten2", "email2", "sdt2" ));
//		users.add(new User(3, "tendangnhap3", "matkhau3", "ten3", "email3", "sdt3" ));
//		users.add(new User(4, "tendangnhap4", "matkhau4", "ten4", "email4", "sdt48" ));
	}
	
	@Override
	public List<User> getUsers() {		
		users = new ArrayList<>();
		try {
			connection = MySQLConnection.getConnection();
			String query = DBConst.GET_ALL_USERS;
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
				
			while (rs.next()) {
				User user = new User();				
				user.setId(rs.getInt("U.ID_USER"));
				user.setTendangnhap(rs.getString("U.TENDANGNHAP"));				
				user.setMatkhau(rs.getString("U.MATKHAU"));
				user.setTen(rs.getString("U.TEN"));
				user.setEmail(rs.getString("U.EMAIL"));
				user.setSdt(rs.getString("U.SDT "));
					
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Khong the ket noi den CSDL");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Loi dong ket noi");
				e.printStackTrace();
			}
		}
		return users;
	}

	@Override
	public User addUser(User user) {
		if(user == null)
			return null;
		
		users.add(user);
		return user;	
	}

	@Override
	public boolean deleteUser(int id) {		
		for(User user : users)
			if(id == user.getId()) {
				users.remove(user);
				return true;
			}
		
		return false;		
	}
}
