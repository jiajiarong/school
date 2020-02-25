package com.rt.ecps.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginFilter implements Filter{
	
	

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest)req;  
	        HttpServletResponse response = (HttpServletResponse)res;  
	       
	          
	    
	        //3.从session中获取sessionKey对应的值；若不存在  则跳转到登陆页面  
	        String redirets="/ecps/console/login.jsp";  
	        Object user = request.getSession().getAttribute("user");  
	        if(user==null){  
	            request.getRequestDispatcher(redirets).forward(request, response);  
	            return;  
	        }  
	        //4若存在 则放行；  
	        chain.doFilter(request, response); 
		
	}

	
}
