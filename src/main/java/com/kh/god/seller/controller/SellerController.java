package com.kh.god.seller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.god.seller.model.service.SellerService;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.StoreInfo;

@Controller
@SessionAttributes(value = {"sellerLoggedIn"})
public class SellerController {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	SellerService sellerService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping("/seller/sellerEnroll.do")
	public String sellerEnroll() {
		
		return "seller/sellerEnroll";
	}
	
	@RequestMapping("seller/checkIdDuplicate.do")
	@ResponseBody
	public Map<String, Object> checkIdDuplicate(@RequestParam("sellerId") String sellerId ) {
		logger.debug("ID중복체크 : "+ sellerId);
		Map<String , Object> map = new HashMap<>();
		Seller s = sellerService.selectOneSeller(sellerId);
		logger.debug("seller"+ s);
		boolean isUsable = s == null ? true:false;
		
		map.put("isUsable", isUsable) ;
		
		return map; 
	}
	
	@RequestMapping("/seller/sellerEnrollEnd.do")
	public String insertSeller(Seller s , Model model) {
		logger.debug("sellerinsert"+ s);
		System.out.println("암화화전 :"+s.getPassword());
		
		String temp = s.getPassword();
		s.setPassword(bcryptPasswordEncoder.encode(temp));
		
		int result = sellerService.insertSeller(s);
		
		String loc = "/seller/sellerEnroll.do";
		String msg = "";
		String view = "";
		System.out.println(result>0?"등록성공":"등록실패");
		
		if(result>0) msg="회원가입성공";
        else msg="회원가입실패!";
       
		model.addAttribute("loc", loc);
		model.addAttribute("msg", msg);
		
		return "common/msg";
	}
	
	@RequestMapping(value = "/seller/sellerLogin.do" ,method = RequestMethod.POST)
	public ModelAndView SellerLogin(@RequestParam String memberId , @RequestParam String password,
			ModelAndView mav , HttpSession session) {
		if(logger.isDebugEnabled())
			logger.debug("로그인 요청!");
		
		Seller s = sellerService.selectOneSeller(memberId);
		
		 String loc = "/";
	     String msg = "";
	     String view = "common/msg";
		
	     if (s == null) {
	         msg = "아이디가 존재하지 않습니다.";
	         loc = "/";
	      } else {
	         // 비밀번호 비교
	         if (bcryptPasswordEncoder.matches(password, s.getPassword())) {
	            // 비밀번호 일치했을시 세션 상태 유지
	            mav.addObject("sellerLoggedIn", s);
	            view = "redirect:/";
	            
	         } else {
	            msg = "비밀번호를 잘못 입력하셨습니다.";
	            loc = "/";
	         }
	      }
	      
	     mav.addObject("loc", loc);
	     mav.addObject("msg", msg);
	     mav.setViewName(view);
		
		return mav;
		
	}
	
	@RequestMapping("/seller/sellerLogout.do")
	public String logout(SessionStatus sessionStatus) {
		
		if(logger.isDebugEnabled())
			logger.debug("로그아웃 요청!"); 
		
	      
	      if(!sessionStatus.isComplete()) {
	         sessionStatus.setComplete();
	      }
	      
	      return "redirect:/";
	 }
	
	@RequestMapping("/seller/sellerView.do")
	public String sellerView(HttpSession session , Model model) {
		
		Seller sellerLoggedIn = (Seller)session.getAttribute("sellerLoggedIn");
		
		Seller s = sellerService.selectOneSeller(sellerLoggedIn.getSellerId());
		
		model.addAttribute("s", s);
		
		return "seller/sellerView";
	}
		
	//내 가게 
	@RequestMapping("/seller/goMyShop.do")
	public String goMyShop(@RequestParam("sellerId") String sellerId,Model model ) {
		List<StoreInfo> store = sellerService.myStore(sellerId);

		//메뉴 뽑기
		//페이지바 만들기
		model.addAttribute("store", store);
		//model.addAttribute("menu", menu);

		
		return "seller/goMyStore";

	}

}
