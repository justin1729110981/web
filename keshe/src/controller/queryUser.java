package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Vo.RaceStar;
import Vo.User;
import Dao.UserDao;

public class queryUser extends HttpServlet {

	public queryUser() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String race=request.getParameter("race");
		String star=request.getParameter("star");
		String page=request.getParameter("page");
		
		String currentpage=request.getParameter("currentpage");

		UserDao dao=new UserDao();
		ArrayList<RaceStar>list=dao.queryUser(race, star, page, currentpage);
		int total=dao.total(race, star);
		HashMap<String,Object>map=new HashMap<String,Object>();
		map.put("total",total);
		map.put("result", list);
		
		
		String jsonStr=(new Gson()).toJson(map);
		
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
