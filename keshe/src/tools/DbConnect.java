package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbConnect {
	
	public Connection conn = null;
	ResultSet rs = null;
	Statement stmt = null;
	
	public DbConnect() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		Class.forName("com.mysql.jdbc.Driver");
		String sConnStr="jdbc:mysql://localhost:3306/stone?useUnicode=true&characterEncoding=utf-8";
		String username="root";
		String password="jrh10272001";
		try {
			 conn = DriverManager.getConnection(sConnStr,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public boolean login(String username ,String password) throws SQLException{
		
		boolean login=false;
		stmt=conn.createStatement();
		String sql="select * from tuser where username='"+username+"' and password='"+password+"'";
		rs=stmt.executeQuery(sql);
		if(rs!=null && rs.next()){
			login=true;
		}
		return login;
		
	}
	
	public boolean CheckUn(String username) throws SQLException{
		boolean isSave=false;
		stmt=conn.createStatement();
		String sql="select * from tuser where username='"+username+"'";
		rs=stmt.executeQuery(sql);
		if(rs!=null && rs.next()){
			isSave=true;
		}
		return isSave;
	}
	
	public boolean add(String username, String password) throws SQLException{
		boolean add=false;
		stmt=conn.createStatement();
		String sql="INSERT INTO tuser(" + "username," + "password) VALUES('" + username + "','" + password + "')";
		int rtn = stmt.executeUpdate(sql);
		if(rtn > 0){
			add=true;
		}
		return add;
	}
	
}
