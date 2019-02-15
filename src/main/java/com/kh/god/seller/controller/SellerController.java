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

import com.kh.god.menu.model.vo.Menu;
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
			logger.debug("판매자 로그인 요청!");
		
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
		
//	//내 가게 
//	@RequestMapping("/seller/goMyShop.do")
//	public String goMyShop(@RequestParam("sellerId") String sellerId, Model model) {
//		
//		if(logger.isDebugEnabled()) {
//			logger.debug("내 가게 보기 요청!"); 
//		}
//		
//		List<StoreInfo> store = sellerService.myStore(sellerId);
//		List<Menu> menu = sellerService.myStoreMenu(sellerId);
//		
//		System.out.println("메뉴 나오라" + menu);
//		
//		//메뉴 뽑기
//		//페이지바 만들기
//		model.addAttribute("store", store);
//		model.addAttribute("menu", menu);
//
//		
//		
//		return "seller/goMyStore";
//
//	}
	
	//내 가게 
	@RequestMapping("/seller/goMyShop.do")
	public ModelAndView goMyShop(@RequestParam("sellerId") String sellerId, 
								 @RequestParam(value = "cPage", defaultValue = "1") int cPage,
								 ModelAndView mav) {
		
		if(logger.isDebugEnabled()) {
			logger.debug("내 가게 보기 요청!"); 
		}
		
		int numPerPage = 10;
		
		// 업무로직
		// 1. 내 가게 현황
		List<StoreInfo> store = sellerService.myStore(sellerId);
		
		// 2. 메뉴 보기 (페이징 적용된 것)
		List<Map<String, String>> menu = sellerService.myStoreMenu(numPerPage, cPage, sellerId);
		System.out.println("메뉴 나오라" + menu);
		
		// 3. 전체 메뉴 수
		int totalContents = sellerService.selectSellerMenuTotalContents(sellerId);
		
		//메뉴 뽑기
		//페이지바 만들기
		mav.addObject("store", store);
		mav.addObject("menu", menu);
		mav.addObject("cPage", cPage);
		mav.addObject("numPerPage", numPerPage);
		mav.addObject("totalContents", totalContents);
		
		mav.setViewName("seller/goMyStore");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/seller/checkPresentPwd.do" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String , Object> checkPresentPwd(HttpSession session , @RequestParam("password") String password , Model model) {
		logger.debug("password"+password);
		
		Map<String, Object> map = new HashMap<>();
		
		Seller sellerLoggedIn = (Seller)session.getAttribute("sellerLoggedIn");
		
		Seller s = sellerService.selectOneSeller(sellerLoggedIn.getSellerId());
		
		String msg = "";
		int result = 0 ;
		
		if(s == null) {
			
			msg = "비밀번호를 다시 확인해 주십시오.";
			
		}else {
			
			if(bcryptPasswordEncoder.matches(password, s.getPassword())) {
				
				msg = "비밀번호 확인 완료";
				result = 1;
			}else {
				msg = "비밀번호가 일치 하지 않습니다.";
			}
			
		}
		
		map.put("result" , result);
		map.put("msg" , msg);
		
		logger.debug("여기까지는 왔냐?"+ map);
		
		return map;
	}
	
	@RequestMapping(value = "/seller/sellerUpdate.do" )
	public String sellerUpdate(HttpSession session , Model model) {
	
		
		return "seller/sellerView";
	}
	

	

}
