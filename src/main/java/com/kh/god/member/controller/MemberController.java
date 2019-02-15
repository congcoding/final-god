package com.kh.god.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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

import com.kh.god.member.model.service.MemberService;
import com.kh.god.member.model.vo.Member;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.StoreInfo;
import com.kh.god.common.util.Utils;


/*******************final 프로젝트 *******************/
@Controller
@SessionAttributes(value = {"memberLoggedIn"}) //value = 문자열 배열로 여러개 넣을수도잇음!
public class MemberController {

	Logger logger = Logger.getLogger(getClass());
	
	//DI : 스프링은 빈을 관리시, 기본적으로 싱글턴을 처리한다.
	@Autowired
	MemberService memberService;
	
	//bean 하나 더 가져오기
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	
	@RequestMapping("/member/memberEnroll.do")
	public String memberEnroll() {	

		if(logger.isDebugEnabled()) { //지금 디버그 모드라면 
			logger.debug("회원등록'페이지' 요청"); //다음을 실행해라 (성능변화가 없음)			
		}
		return "/member/memberEnroll";	// 
	}
	

	@RequestMapping("/member/memberEnrollEnd.do")
	public ModelAndView insertMember(Member m,
							   @RequestParam (name="upFile",required = false) MultipartFile upFiles,	
							   HttpServletRequest request, ModelAndView mav) {
		
		logger.debug("회원등록 요청");		
		logger.debug("fileName= "+ upFiles.getOriginalFilename());
		logger.debug("size1= "+upFiles.getSize());
		
		try {
			//1. 파일 업로드
			String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload/member");
			logger.debug(saveDirectory);
			
			//2. multipartFile 처리
			if(!upFiles.isEmpty()) {
				//파일명 (업로드용) 
				String oldFile = upFiles.getOriginalFilename();
				
				//파일명(서버저장용)
				String renamedFile = Utils.getRenamedFileName(oldFile);
				
	    		//실제 파일 저장
	    		try {
	    			upFiles.transferTo(new File(saveDirectory+"/"+renamedFile));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    		
	    		
			}
			
	        //System.out.println("암호화 전 : "+m.getPassword());
	        String temp = m.getPassword();
	        
	        //BCrypt 방식 암호화
	        m.setPassword(bCryptPasswordEncoder.encode(temp));
	        //System.out.println("암호화 후 : "+m.getPassword());
	        System.out.println("memberController@member="+m);
	     
			/*
			 * int result = memberService.insertMember(m);
			 * 
			 * String loc="/"; String msg ="";
			 * 
			 * if(result>0) msg="회원가입성공"; else msg="회원가입실패!";
			 * 
			 * req.setAttribute("loc", loc); req.setAttribute("msg", msg);
			 * 
			 * return "common/msg";
			 */
		}catch(Exception e) {
	    	logger.error("게시물 등록 에러", e);
	    }
        
        return mav;
     }

	
	
	/**
	 * ModelAndView(2.0) 
	 *  - Model과 view단 정보를 하나의 객체에서 관리
	 *  
	 * ModelMap(2.0) : 일반클래스
	 * 	- Model 객체관리, view 단은 문자열로 리턴
	 * ----------------------------------------
	 * Model(2.5) : 인터페이스
	 *  - Model 객체관리, view 단은 문자열로 리턴
	 */
	@RequestMapping(value = "/member/memberLogin.do", method = RequestMethod.POST)
    public ModelAndView memberLogin(@RequestParam String memberId, @RequestParam String password,
                              ModelAndView mav, HttpSession session) {
      if(logger.isDebugEnabled()) {
         logger.debug("로그인 요청");
      }
        Member m = memberService.selectOneMember(memberId);
        
        String msg = "";
        String loc = "/";
        String view = "/common/msg";
        //로그인 처리
        if(m == null) {
            msg = "아이디가 존재하지 않습니다.";
        }else {
            //비밀번호 비교
            System.out.println(password);
            if(bCryptPasswordEncoder.matches(password, m.getPassword())) {
                //세션 = 상태유지
                //session.setAttribute("memberLoggedIn",m);  // 세션에 직접 지정하는 방법
                mav.addObject("memberLoggedIn",m);
                view = "redirect:/";
            }else {
                msg = "비밀번호가 틀렸습니다.";
            }                
        }
        
        mav.addObject("loc", loc);
        mav.addObject("msg", msg);
        mav.setViewName(view);
        
        return mav;
    }


	
	@RequestMapping("/member/memberLogout.do")
	public String memberLogout(SessionStatus sessionStatus) {
		if(logger.isDebugEnabled())
			logger.debug("로그아웃 요청");
		
		//session.setAttribute() 로 로그인 했다면 session.invalidate() 로 무효화
		
		//@sessionAttribute 로 로그인 했다면, sessionStatus.setComplete() 로 무효화
		if(!sessionStatus.isComplete()) sessionStatus.setComplete();
		
		return "redirect:/";
	}

	
	@RequestMapping("/member/memberView.do")
	public String memberView(@RequestParam String memberId, Model model) {	
		if(logger.isDebugEnabled()) { 
			logger.debug("회원'정보' 페이지 요청"); 		
		}
			
		Member m = memberService.selectOneMember(memberId);
		
		model.addAttribute("m",m);
		
		String view = "member/memberView";
				
		return view; 
	}
		
	@RequestMapping("/member/memberUpdate.do")
	public String memberUpdate(Member m, Model model) {	
		if(logger.isDebugEnabled()) { 
			logger.debug("회원정보 업데이트 요청"); 		
		}
		
		 int result = memberService.updateMember(m);
		
		 String loc="/";
	     String msg ="";
	     String view = "common/msg"; 
	     
	     if(result>0) {
	    	 msg = "회원정보 수정완료";
	    	 loc = "/member/memberView.do?memberId="+m.getMemberId();
	     }
	     else {
	    	 msg = "회원정보 수정실패";
	     }
	        
	        model.addAttribute("loc", loc);
	        model.addAttribute("msg", msg);
	         
	    return view;
	}

	
	
	/**
	 * @ResponseBody 어노테이션을 이용하여
	 * 리턴된 객체럴 jsonString으로 자동변환하여 전송
	 */
	 @RequestMapping("/member/checkIdDuplicate.do")
	 @ResponseBody
	 public Map<String,Object> checkIdDuplicate(@RequestParam("memberId") String memberId) {
	 //처리된 값을 받아둘 model 객체 선ㅇ너
	 
		 logger.debug("ID중복체크 : "+memberId); 
		 Map<String,Object>map = new HashMap<>();
		 
		 Member m = memberService.selectOneMember(memberId); 
		 boolean isUsable = m == null? true:false;
		 
		 map.put("isUsable", isUsable);
	 
		 return map; //BeanNameViewResolver에 의해 처리될 bean 객체 
	 
	 }
	
	
}

