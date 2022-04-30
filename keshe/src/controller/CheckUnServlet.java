package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.DbConnect;
import Dao.UserDao;
import Vo.User;

public class CheckUnServlet extends HttpServlet {
	public CheckUnServlet() {
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
		
		String uname = request.getParameter("username");
		UserDao dao = new UserDao();
		
		DbConnect db = null;			
		try {
			db = new DbConnect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
			if(db.CheckUn(uname) || uname.equals("")){
				out.print("0");
			}else{
				out.print("1");
			}				
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
