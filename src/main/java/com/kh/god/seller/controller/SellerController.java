package com.kh.god.seller.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.god.common.util.Utils;
import com.kh.god.menu.model.vo.Menu;
import com.kh.god.seller.model.service.SellerService;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.Attachment;
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
	public String goMyShop(@RequestParam("sellerId") String sellerId, Model model) {
		
		if(logger.isDebugEnabled()) {
			logger.debug("내 가게 보기 요청!"); 
		}
		
		List<StoreInfo> store = sellerService.myStore(sellerId);
		
		List<Menu> menu = sellerService.myStoreMenu(sellerId);
		
		System.out.println("메뉴 나오라" + menu);
		
		//메뉴 뽑기
		//페이지바 만들기
		model.addAttribute("store", store);
		model.addAttribute("menu", menu);

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
		
		logger.debug("여기까지는 왔냐?"+ map);
		
		return map;
	}
	
	@RequestMapping(value = "/seller/sellerUpdate.do" )
	public String sellerUpdate(HttpSession session , Model model) {
	
		
		return "seller/sellerView";
	}
	

	

    @RequestMapping("/seller/goUpdateMyStore.do")
    public String goUpdateMyStore(@RequestParam("storeNo") String storeNo, Model model) {
    	//' ' 제거 
    	storeNo = storeNo.replace("'", "");
  
    	List<Map<String, Object>> store = sellerService.getStoreInfoBystoreNo(storeNo);   
    	List<Attachment> attachment = sellerService.getAttachment(storeNo);
    	model.addAttribute("store", store);
    	model.addAttribute("attachment", attachment);

    	return "seller/updateMyStoreInfo";
    }

    //내 가게 정보수정
    /*@RequestMapping("/seller/updateStore.do")
    public String updateStore(@RequestParam("startChooseAmPm") String startChooseAmPm,
    		@RequestParam("startTime") String startTime,
    		@RequestParam("endChooseAmPm") String endChooseAmPm,
    		@RequestParam("endTime") String endTime,
    		@RequestParam("locationStartNum") String locationStartNum,
    		@RequestParam("tel1") String tel1,
    		@RequestParam("tel2") String tel2,
    		@RequestParam("address1") String address1,
    		@RequestParam(name="address2" , required = false) String address2,
    		@RequestParam("thumbImg") MultipartFile upFiles,
    		HttpServletRequest request, StoreInfo storeInfo
    		) {
    	
    	//파일
    	try {
			// 1. 파일업로드 (실제경로를 얻어내는 방법은 세션-서블릿-리얼패스)
			String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload/storeInfo/thumbNail");

			logger.debug("saveDirectory = " + saveDirectory);

			List<Attachment> attachList = new ArrayList<>();

			// MultipartFile 처리
				if (!upFiles.isEmpty()) {
					// 사용자가 업로드한 파일명 구하기
					String originalFileName = upFiles.getOriginalFilename();

					// 서버저장용 파일명
					String renamedFileName = Utils.getRenamedFileName(originalFileName);
					logger.debug("renamedFileName = " + renamedFileName);

					// 실제서버에 파일저장
					try {
						upFiles.transferTo(new File(saveDirectory + "/" + renamedFileName));
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}

					// 첨부파일객체 생성. 리스트 추가
					Attachment attach = new Attachment();
					attach.setOriginalFileName(originalFileName);
					attach.setRenamedFileName(renamedFileName);
					attachList.add(attach);
				}
    	} catch (Exception e) {
		logger.error("썸네일 등록 에러", e);
		
	}
    	
    	String operatingHours = startChooseAmPm+startTime+"시 ~"+endChooseAmPm+endTime;
    	String storeTel = locationStartNum+"-"+tel1+"-"+tel2;
    	String storeAddress = "";
    	if(!address2.equals("")) {
    		storeAddress = address1+" "+address2;
    	} else {
    		storeAddress = address1;
    	}
    	
    	//int updateThumb = sellerService.updateStoreInfo();

    	return ":/redirect";
    }*/

}
