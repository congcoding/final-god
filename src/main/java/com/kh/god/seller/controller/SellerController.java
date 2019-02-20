package com.kh.god.seller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.kh.god.storeInfo.model.vo.MenuAttachment;
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
		//logger.debug("seller"+ s);
		boolean isUsable = s == null ? true:false;
		
		map.put("isUsable", isUsable) ;
		
		return map; 
	}
	
	@RequestMapping("/seller/sellerEnrollEnd.do")
	public String insertSeller(Seller s , Model model) {
		//logger.debug("sellerinsert"+ s);
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
	
		//System.out.println("@@@@@@@@@"+ s.getPhone());
		
		model.addAttribute("s", s);
		
		return "seller/sellerView";
	}
		
	//내 가게 
	@RequestMapping("/seller/goMyShop.do")
	public String goMyShop(@RequestParam("sellerId") String sellerId, Model model) {
		
		if(logger.isDebugEnabled()) {
			logger.debug("내 가게 보기 요청!"); 
		}
		
		List<StoreInfo> store = sellerService.myStore(sellerId);
		
//		List<Menu> menu = sellerService.myStoreMenu(sellerId);
		
//		System.out.println("메뉴 나오라" + menu);
		
		//메뉴 뽑기
		//페이지바 만들기
		model.addAttribute("storeSideBar", store);
		model.addAttribute("store", store);
//		model.addAttribute("menu", menu);

		return "seller/goMyStore";

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
		
		//logger.debug("여기까지는 왔냐?"+ map);
		
		return map;
	}
	
	@RequestMapping(value = "/seller/sellerUpdate.do" )
	public String sellerUpdate(HttpSession session , Model model , Seller seller) {
		
		logger.debug("!!!!!!!!!!!!!!!!!!!!"+seller);
		
		int result = sellerService.updateSeller(seller);
		
		Seller sellerLoggedIn = (Seller)session.getAttribute("sellerLoggedIn");
		Seller s = sellerService.selectOneSeller(sellerLoggedIn.getSellerId());
		
		String loc = "/seller/sellerView.do";
		String msg = "";
		
		
		if(result>0) {
			msg ="수정 성공";
			
		}else{
			msg ="수정 실패";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
	
		
		return "common/msg";
	}
	
	@RequestMapping(value ="/seller/updatePwd.do" , method = RequestMethod.POST )
	@ResponseBody
	public Map<String, Object> updatePwd(@RequestParam("password") String password ) {
		
		
		Map<String, Object> map = new HashMap<>();
		String temp = password;
		
		password = bcryptPasswordEncoder.encode(temp);
		
		int result = sellerService.updatePwd(password);
		String msg = "";
		
		if(result > 0) {
			msg ="비밀번호 변경 성공";
		}else {
			msg ="비밀번호 변경 실패";
		}
		
		map.put("msg", msg);
		
		return map;
	}

	@RequestMapping(value = "/seller/goMyStoreOrder.do" )
	public String goMyStoreOrder(@RequestParam("storeNo") String storeNo,Model model) {
		System.out.println("@@storeNo=>>>>>"+storeNo);
		//접수대기 오더리스트
		List<Map<String, Object>> orderList1 = sellerService.orderList1(storeNo);
		
		
		model.addAttribute("orderList1",orderList1);
		
		return "seller/MyStoreOrder";
	}
	
	

	
    @RequestMapping("/seller/goUpdateMyStore.do")
    public String goUpdateMyStore(@RequestParam("storeNo") String storeNo, Model model) {
    	//' ' 제거 
    	storeNo = storeNo.replace("'", "");
  
    	List<Map<String, Object>> store = sellerService.getStoreInfoBystoreNo(storeNo);   
    	List<MenuAttachment> attachment = sellerService.getAttachment(storeNo);
    	List<MenuAttachment> thumbAttachment = sellerService.getthumbAttachment(storeNo);
    	model.addAttribute("store", store);
    	model.addAttribute("attachment", attachment);
    	model.addAttribute("thumbAttachment", thumbAttachment);
    	
    	List<StoreInfo> storeSideBar = sellerService.myStore("seller1");
    	model.addAttribute("storeSideBar", storeSideBar);

    	return "seller/updateMyStoreInfo";
    }

    //내 가게 정보수정
    @RequestMapping("/seller/updateStoreInfo.do")
    public String updateStore(
    		@RequestParam(name="operatingHours" , required = false) String operatingHours,
    		@RequestParam(name="locationStartNum" , required = false) String locationStartNum,
    		@RequestParam(name="tel1" , required = false) String tel1,
    		@RequestParam(name="tel2" , required = false) String tel2,
    		@RequestParam(name="address1" , required = false) String address1,
    		@RequestParam(name="address2" , required = false) String address2,
    		@RequestParam(name="personalday" , required = false) String personalday,
    		@RequestParam(name="nowThumb" , required = false) String nowThumb,
    		@RequestParam(name="newThumb" , required = false) String newThumb,
    		@RequestParam(name="storeNo") String storeNo,
    		Model model
	
    		) {

    	String storeTel = locationStartNum+"-"+tel1+"-"+tel2;
    	String storeAddress = "";
    	if(!address2.equals("")) {
    		storeAddress = address1+" "+address2;
    	} else {
    		storeAddress = address1;
    	}
    	
		Map<String , Object> map = new HashMap<>();
		map.put("storeNo",storeNo);
		map.put("operatingHours",operatingHours);
		map.put("storeTel",storeTel);
		map.put("storeAddress",storeAddress);
		map.put("personalday",personalday);

    	//업데이트
    	int result = sellerService.updateStoreInfo(map);
		String msg = "";

    	if(result>0) {
    		msg="수정이 완료되었습니다";
    	} else {
    		msg="수정실패";
    	}
    	
    	if(!nowThumb.equals(newThumb)) {
    		//썸네일을 바꾼 경우
    		//전에 했던 썸네일 Flag=N으로 업데이트 
    		int oldThumbNail = sellerService.oldThumbNail(nowThumb);
    		//뉴 썸네일 Flag=Y로 업데이트
    		int changeThmbNail = sellerService.changeThmbNail(newThumb);
    	}
    	
    	System.out.println("storeNo=>"+storeNo);

    	//int updateThumb = sellerService.updateStoreInfo();

    	return "common/msg";

    }
    
//    @RequestMapping("/seller/selectMenuList.do")
//    @ResponseBody
//    public List<Menu> selectMenuList(@RequestParam("storeNo") String storeNo, Model model) {
//		System.out.println("사업자 번호 왔냐? " + storeNo);
//    	
//		List<Menu> menu = sellerService.selectMenuList(storeNo);
//		
//		System.out.println("메뉴 왔냐? " + menu);
//		
//		model.addAttribute("menu", menu);
//		
//    	return menu;
//    	
//    }
    
	@RequestMapping("/seller/updateMenu.do")
	public String updateMenu(@RequestParam("storeNo") String storeNo, Model model) {
		System.out.println("사업자 번호 왔냐? " + storeNo);

		List<Menu> menu = sellerService.selectMenuList(storeNo);

		System.out.println("메뉴 왔냐? " + menu);

		model.addAttribute("menu", menu);

		return "seller/updateMenu";
	}
	
	@RequestMapping("/seller/soldout.do")
	public String soldOut(@RequestParam("menuCode") String menuCode) {
		
		return menuCode;
	}

}
