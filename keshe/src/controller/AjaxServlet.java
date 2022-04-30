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

public class AjaxServlet extends HttpServlet {


	public AjaxServlet() {
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
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		String saveCode = (String)request.getSession().getAttribute("code");
	
		if(!code.equalsIgnoreCase(saveCode)) {
			out.println("验证码错误");
			out.flush();
			out.close();
			return;
		}
		
		UserDao dao = new UserDao();
		
		DbConnect db = null;			
		try {
			db = new DbConnect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			User user = dao.login(uname, password);
			try{
				if(db.login(uname, password)){
					request.getSession().setAttribute("currentUser", user);
					request.getRequestDispatcher("main.jsp").forward(request, response);
					out.print(0);
				}else{
					out.println("用户名或者密码错误");
					out.flush();
					out.close();
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
