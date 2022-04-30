package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.CreateImage;

public class VcodeServlet extends HttpServlet {
	public VcodeServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random random = new Random();
		String s = "AQ";
		int index = random.nextInt(s.length());
		String c = String.valueOf(s.charAt(index));
		if(c.equals("A")){
			String code = createRadomCodeString();
			request.getSession().setAttribute("code", code);
			response.setContentType("img/jpeg");
			BufferedImage image = CreateImage.create(code);
			ServletOutputStream out = response.getOutputStream();
			ImageIO.write(image, "JPEG", out);
			out.flush();
			out.close();
		}else{
			String code = createRadomExpression(request);
			
			
			response.setContentType("img/jpeg");
			BufferedImage image = CreateImage.create(code);
			ServletOutputStream out = response.getOutputStream();
			ImageIO.write(image, "JPEG", out);
			out.flush();
			out.close();
		}
		
	}
	
	public String createRadomCodeString() {
		//String code = "";
		String s = "123456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKMNPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 4;i++) {
			Random random = new Random();
			int index = random.nextInt(s.length());
			sb.append(s.charAt(index));
		}
		return sb.toString();
	}
	
	public String createRadomExpression(HttpServletRequest request){
		String s1 = "123456789";
		String s2 = "+-*";
		StringBuffer sb = new StringBuffer();
		
		Random random = new Random();
		int number1 = random.nextInt(s1.length());
		int c = random.nextInt(s2.length());
		int number2 = random.nextInt(s1.length());
		int n1 = Integer.parseInt(String.valueOf(s1.charAt(number1)));
		int n2 = Integer.parseInt(String.valueOf(s1.charAt(number2)));
		
		request.getSession().setAttribute("code", CheckVcode(n1,s2.charAt(c), n2));
		sb.append(s1.charAt(number1));
		sb.append(s2.charAt(c));
		sb.append(s1.charAt(number2));
		return sb.toString();
	}
	
	public String CheckVcode(int number1, char c, int number2){
		int sum = 0;
		if(c == '+'){
			sum = number1 + number2;
		}else if(c == '-'){
			sum = number1 - number2;
		}else{
			sum = number1*number2;
		}
		String str = String.valueOf(sum);
		return str;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		*/
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
