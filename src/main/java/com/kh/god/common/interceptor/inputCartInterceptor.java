package com.kh.god.common.interceptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.god.menu.model.vo.Menu;

/**
 * 카트 세션에서 꺼내기?
 */
public class inputCartInterceptor extends HandlerInterceptorAdapter {
	
	Logger logger = Logger.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		List<Menu> menuCart = new ArrayList<Menu>();
		
		Menu menu = (Menu)session.getAttribute("menu");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

			
		
		return super.preHandle(request, response, handler);
	}
	
	
	
	
	
}
