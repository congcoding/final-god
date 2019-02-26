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
 *  /member/memberView.do" 
 *  /member/memberUpdate.do"
 *  
 *  /seller/sellerView.do
	seller/sellerUpdate.do
 *  요청시 로그인 여부를 검사하고, 로그인 하지 않았다면, common/msg.jsp 에서 경고메세지 출력
 * 
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	Logger logger = Logger.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 주소랑 로그인한 사람이 다를때
		String memberId = request.getParameter("memberId");
		HttpSession session = request.getSession();
		
		Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn");
		Seller sellerLoggedIn = (Seller)session.getAttribute("sellerLoggedIn"); 

		//회원이 로그인을 안한 상태나 다른 아이디로 memberView나 memberUpdate에 접근시 차단
		if(memberLoggedIn == null || !memberId.equals(memberLoggedIn.getMemberId())){ 
			
			request.setAttribute("msg", "올바른 접근이 아닙니다");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
					
			return false; 
		}
		if(sellerLoggedIn == null) {
			request.setAttribute("msg", "올바른 접근이 아닙니다");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
					
			return false; 
		}
		
	
		
		
		
		return super.preHandle(request, response, handler); // 이 값은 항상 트루
	}

}

