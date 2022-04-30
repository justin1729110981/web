package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import tools.DbConnect;
import Dao.UserDao;
import Vo.User;

public class RegisterAjaxServlet extends HttpServlet {
	public RegisterAjaxServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//String id=request.getParameter("id");
		Random r = new Random();
		String id=String.valueOf(r.nextInt(100) + 1);
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String country=request.getParameter("country");
		
		UserDao dao = new UserDao();
		
		DbConnect db = null;
		try {
			db = new DbConnect();
			Statement stmt = db.conn.createStatement();
			String sql="INSERT INTO tuser(id,username,password,country) VALUES('"+id+"','" + username + "','" + password + "','"+country+"')";
			int i=stmt.executeUpdate(sql);
			if(i>0)
				out.print(0);
			else{
				out.print(1);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
