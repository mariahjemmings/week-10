package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.dog;

public class Dogdao {
	
	private Connection connection;
	private final String Get_Dogs_Query = "Select * FROM dog";
	private final String Get_Dog_Query = "Select * FROM dog WHERE id = ?";
	private final String Create_Dogs_Query = "INSERT INTO dog(id, name, breed, age) VALUES(?,?,?,?)";
	private final String Update_Dogs_Query = "UPDATE dog SET name =?, breed=?, age=? WHERE id=?";
	private final String Delete_Dogs_Query = "DELETE FROM dog WHERE id = ?";	
	
	
	public Dogdao () {
		connection = DBconnection.getConnection();
	}
	
	public List <dog> getDogs () throws SQLException {
		ResultSet rs = connection.prepareStatement(Get_Dogs_Query).executeQuery();
		List <dog> dog = new ArrayList <dog>();
		while (rs.next()) {
			dog b = new dog();
			b.setDogId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setBreed(rs.getString(3));
			b.setAge(rs.getInt(4));
			dog.add(b);
		}
		return dog;
		
	}
	
	private dog populateDogs(int ID, String name, String breed, int age) {
		return new dog(ID, name, breed, age);
		
	}
	
	public dog getdogbyid(int id) throws SQLException {
		
		PreparedStatement ps = connection.prepareStatement(Get_Dog_Query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateDogs(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	}
	public void createdog(int id, String name, String breed, int age) throws SQLException {
		
		PreparedStatement ps = connection.prepareStatement(Create_Dogs_Query);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, breed);
		ps.setInt(4, age);
		ps.executeUpdate();
		
	
}
	
public void deletedogbyid(int id) throws SQLException {
PreparedStatement ps = connection.prepareStatement(Delete_Dogs_Query);
ps.setInt(1, id);
ps.executeUpdate();}

public void updateadog(int id, String name, String breed, int age) throws SQLException {
	
	PreparedStatement ps = connection.prepareStatement(Update_Dogs_Query);
	ps.setInt(4, id);
	ps.setString(1, name);
	ps.setString(2, breed);
	ps.setInt(3, age);
	ps.executeUpdate();
}
}