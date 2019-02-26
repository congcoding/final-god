package com.kh.god.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.god.member.model.vo.Member;
import com.kh.god.seller.model.vo.Seller;

/**
 *  !! 로그인이 되었고, 당사자여야지 접근가능
 *  /seller/sellerView.do
	seller/sellerUpdate.do
 *  요청시 로그인 여부를 검사하고, 로그인 하지 않았다면, common/msg.jsp 에서 경고메세지 출력
 * 
 */
public class SellerLoginCheckInterceptor extends HandlerInterceptorAdapter {

	Logger logger = Logger.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 주소창의 아이디값
		String sellerId = request.getParameter("sellerId");
		
		// 로그인한 사람 값
		HttpSession session = request.getSession();		
		Seller sellerLoggedIn = (Seller)session.getAttribute("sellerLoggedIn"); 

		
		if(sellerLoggedIn != null) {
			
			if(!sellerId.equals(sellerLoggedIn.getSellerId())) { 
				request.setAttribute("msg", "올바른 접근이 아닙니다");
				request.setAttribute("loc", "/");
				request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
						
				return false; 				
			}
			
		}else { 
			request.setAttribute("msg", "로그인 후 진행하세요");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return false;
		}
				

		
		return super.preHandle(request, response, handler); // 이 값은 항상 트루
	}

}

