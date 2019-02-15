package com.kh.god.admin.controller;


import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.god.admin.model.service.AdminService;
import com.kh.god.admin.model.vo.Event;
import com.kh.god.admin.model.vo.QnaBoard;
import com.kh.god.common.util.Utils;
import com.kh.god.seller.model.vo.Seller;

@Controller
public class AdminController {
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/admin/qnaboard.do")
	public String selectBoardList(@RequestParam(value="cPage",defaultValue="1") int cPage, Model model) {
		
		int numPerPage = 10;
		
		List<Map<String,String>> list = adminService.selectBoardList(cPage,numPerPage);
		
		int totalContents = adminService.countBoardList();
		
		model.addAttribute("cPage",cPage);
		model.addAttribute("numPerPage",numPerPage);
		model.addAttribute("list",list);
		
		model.addAttribute("totalContents",totalContents);
		
		return "admin/boardList";
	}

	@RequestMapping("/admin/dashBoard.do")
	public void dashBoard() {
	
	}

	@RequestMapping("/admin/memberList.do")
	public void memberList() {
	}
	
	@RequestMapping("/admin/eventForm.do")
	public void eventForm() {
	}
	
	@RequestMapping("/admin/eventList.do")
	public String eventList(@RequestParam(value="cPage",defaultValue="1") int cPage, Model model) {
		int numPerPage = 10;
		List<Map<String,String>> list = adminService.eventList(cPage,numPerPage);
		int totalContents = adminService.countEventList();
		
		model.addAttribute("cPage",cPage);
		model.addAttribute("numPerPage",numPerPage);
		model.addAttribute("totalContents",totalContents);
		model.addAttribute("list",list);
		return "admin/eventList";
	}
	
	@RequestMapping("/admin/insertEvent.do")
	public ModelAndView insertEvent(@RequestParam(name="eventTitle") String eventTitle,@RequestParam(name="amount") int amount,
									@RequestParam(name="startDate") Date startDate, @RequestParam(name="endDate") Date endDate,
									@RequestParam(name="discount") String discount,@RequestParam(name="upFile",required=false) MultipartFile[] upFiles, HttpServletRequest request, ModelAndView mav) {
	

			//file upload
			String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload/event");
			
			int eventNo = adminService.getLastEventNo();
			
			String oSmall = upFiles[0].getOriginalFilename();
			String oBig = upFiles[1].getOriginalFilename();
			String rSmall = Utils.getRenamedEventFileName(oSmall,"s",eventNo);
			String rBig = Utils.getRenamedEventFileName(oBig,"b",eventNo);
			
			
			//실제 서버에 파일 저장
			try {
				upFiles[0].transferTo(new File(saveDirectory+"/"+rSmall));
				upFiles[1].transferTo(new File(saveDirectory+"/"+rBig));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			Event event = new Event();
			event.setEventTitle(eventTitle);
			event.setDiscount(discount);
			event.setAmount(amount);
			event.setStartDate(startDate);
			event.setEndDate(endDate);
			event.setEventBig(rBig);
			event.setEventSmall(rSmall);
		
			int result = adminService.insertEvent(event);
			
			//view
			
			String msg = "";
			if(result>0) {
				msg="게시물 등록 성공";
			}else {
				msg = "게시물 등록 실패";
			}
			
			mav.addObject("msg",msg);
			mav.addObject("loc","/admin/eventList.do");
			mav.setViewName("common/msg");
		
		return mav;
			
	}
	
	@RequestMapping("/admin/boardView.do")
	public String qnaboardView(@RequestParam int boardNo, Model model) {
		QnaBoard b = adminService.qnaBoardView(boardNo);
		model.addAttribute("board",b);
		return "admin/boardView";
	}
	
	@RequestMapping("/admin/allMemberList.do")
	public String allMemberList() {
		return "/admin/allMemberList";
	}
	
	@RequestMapping("/admin/sellerList.do")
	public String selletList(@RequestParam(value="cPage",defaultValue="1") int cPage,Model model) {
		
		int numPerPage = 6;
		
		List<Map<String,String>> seller = adminService.selectSellerAllList(cPage,numPerPage);
		
		int totalContents = adminService.countSellerList();
		
		model.addAttribute("cPage",cPage);
		model.addAttribute("numPerPage",numPerPage);
		model.addAttribute("seller",seller);
		model.addAttribute("totalContents",totalContents);
		
		return "admin/sellerList";
		
	}
	
	@RequestMapping("/admin/eventView.do")
	public String eventView(@RequestParam(name="eventNo") int eventNo, Model model) {
		Event e = adminService.eventView(eventNo);
		model.addAttribute("event", e);
		return "admin/eventView";
	}
	
	
}
