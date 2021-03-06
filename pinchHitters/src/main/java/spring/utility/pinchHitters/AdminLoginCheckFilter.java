package spring.utility.pinchHitters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminLoginCheckFilter implements Filter{
	public void init(FilterConfig arg0) throws ServletException {
}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)
	throws IOException, ServletException {
		
		//Filterκ°? ?μ²? μ€κ°?? requestκ°μ²΄λ₯? μΆμΆ?©??€.
		HttpServletRequest httpRequest =(HttpServletRequest)request;
		
		//?λ‘μ΄ ?Έ?? ??±?μ§? ?κ³? request κ°μ²΄?? κΈ°μ‘΄? ?Έ? λ°ν
		HttpSession session = httpRequest.getSession(false);
		
		
		//λ‘κ·Έ?Έ ?μ§? ??Έ?€κ³? κ°?? 
		boolean login = false;
		
		if (session != null ) {//session κ°μ²΄κ°? ??±??΄ ??μ§? ??Έ
			// λ‘κ·Έ?Έ? ??Όλ©΄μ κ΄?λ¦¬μ?Έμ§? ??Έ?©??€.
			if(session.getAttribute("id") != null
					&& session.getAttribute("grade").equals("A")) {
			login = true;//κ΄?λ¦¬μ ??Έ
		}
		
	}
	// ? ?? ?Όλ‘? λ‘κ·Έ?Έ?΄ ???€λ©? ?μ²? ??΄μ§?λ‘? ?΄??©??€
		if(login) {
			chain.doFilter(request, response);
		} else {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/member/login.do");
		dispatcher.forward(request, response);
	}
}
public void destroy() {
}
}

