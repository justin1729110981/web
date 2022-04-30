package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse rep = (HttpServletResponse)arg1;
		
		String url = req.getRequestURL().toString();
		String login = String.valueOf(req.getSession().getAttribute("login"));
		if(url.endsWith("login.html") || url.endsWith("VcodeServlet") || url.endsWith("AjaxServlet") || url.endsWith("LogoutServlet")
				|| url.endsWith("RegisterAjaxServlet") || url.endsWith("Register.html") || url.endsWith("main.jsp") || url.endsWith("CheckUnServlet")
				|| url.endsWith("queryRace") || url.endsWith("queryStar") || url.endsWith("queryUser") || url.endsWith("main.html")
				|| url.endsWith(".jpg") || url.endsWith("css") || url.endsWith("js") || url.endsWith("main.js") || url.endsWith("deleteUser")
				|| url.endsWith("addUser") || url.endsWith("clearUser")){
			arg2.doFilter(arg0, arg1);
			return;
		}
		if(req.getSession().getAttribute("hasLogin") == null){
			rep.sendRedirect("login.html");
		} else {
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
