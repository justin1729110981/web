package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.Star;
import Dao.UserDao;

public class clearUser extends HttpServlet {
	public clearUser() {
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

		HashMap<String,Object>map=new HashMap<String,Object>();
		UserDao userDao=new UserDao();
		String raceId=request.getParameter("raceId");
		String starNumber=request.getParameter("starNumber");
		ArrayList<Star> list = null;

		try {
			list = userDao.queryStar(raceId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		
		String jsonStr = gson.toJson(list);
		
		//out.print(jsonStr);
		if(userDao.clear(raceId,starNumber))
		{
			out.print(0);
		}
		
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
