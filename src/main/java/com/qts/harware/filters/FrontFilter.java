package com.qts.harware.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FrontFilter
 */
@WebFilter
public class FrontFilter implements Filter
{
	private ServletContext context;

    /**
     * Default constructor. 
     */
    public FrontFilter()
    {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() 
	{		

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> params = req.getParameterNames();
		while(params.hasMoreElements())
	    {
		    String username = params.nextElement();
			String password = request.getParameter(username);
			this.context.log(req.getRemoteAddr() + "::Request Params::{"+username+"="+password+"}");
		}
		Cookie[] cookies = ((HttpServletRequest) request).getCookies();
		if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				this.context.log(req.getRemoteAddr() + "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}");
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		this.context = fConfig.getServletContext();
		this.context.log("forntcontroller initialized");
	}
	
}
