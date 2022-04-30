package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

public class updateUser extends HttpServlet {

	public updateUser() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String raceId=request.getParameter("idWindow");
		String raceName=request.getParameter("raceWindow");
		String starNumber=request.getParameter("starWindow");
		String name=request.getParameter("nameWindow");
		
		HashMap<String,Object>map=new HashMap<String,Object>();
		UserDao userDao=new UserDao();
		
		if(userDao.update(raceId,raceName, starNumber, name))
		{
			out.print(0);
		}
		
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
