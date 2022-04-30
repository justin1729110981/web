package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.UserDao;

public class deleteUser extends HttpServlet {
	public deleteUser() {
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String ids=request.getParameter("ids");
		
		HashMap<String,Object>map=new HashMap<String,Object>();
		UserDao userDao=new UserDao();
		if(name!=null && !"".equals(name))
		{
			if(userDao.delete(name))
			{
				map.put("code",0);
				map.put("msg","delete successfully");
			}
			else
			{
				map.put("code",1);
				map.put("msg","delete unsuccessfully!");
			}
		}
				
		if(ids!=null && !"".equals(ids))
		{
			if(userDao.deleteBatch(ids))
			{
				map.put("code",0);
				map.put("msg","delete successfully");
			}
			else
			{
				map.put("code",1);
				map.put("msg","delete unsuccessfully!");
			}
		}
		
		String json=(new Gson()).toJson(map);
		out.print(json);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
