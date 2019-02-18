package com.kh.god.admin.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("/admin/sellerBlackList.do")
	public String blackListChange(@RequestParam String sellerId, @RequestParam String bFlag) {
		int result = 0;
		if((bFlag).equals("Y")) {
			result = adminService.changeSellerbFlagtoN(sellerId);
		}else {
			result = adminService.changeSellerbFlagtoY(sellerId);
		}
		
		
		return "redirect:/admin/sellerList.do";
	}
	
	@RequestMapping("/admin/askingList.do")
	public String askingList(@RequestParam(value="cPage",defaultValue="1") int cPage, @RequestParam String memberId, @RequestParam String sellerId, Model model) {
		int numPerPage = 6;
		List<Map<String,String>> list = null;
		int totalContents = 0;
		if(memberId != null) {
			list = adminService.selectMemberQNAList(cPage,numPerPage,memberId);
			totalContents = adminService.countMemberQNAList(memberId);
			
		}else if(sellerId != null) {
			list = adminService.selectSellerQNAList(cPage,numPerPage,sellerId);
			totalContents = adminService.countSellerQNAList(sellerId);
		}
		
		model.addAttribute("cPage",cPage);
		model.addAttribute("numPerPage",numPerPage);
		model.addAttribute("list",list);
		model.addAttribute("totalContents",totalContents);
		return "admin/askingList";
	}
	
	@RequestMapping("/admin/eventFileDownload.do")
	public void fileDownload(@RequestParam String fileName, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		
		//파일 입출력 준비
		String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload/event");
		
		//입력 스트림
		File f = new File(saveDirectory+"/"+fileName);
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		//출력스트림
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		
		//전송할 파일명작성
		String resFileName = "";
		
		//요청브라우저에 따른 분기를 처리
		boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1 //요청브라우저를 가져오는 key
						|| request.getHeader("user-agent").indexOf("Trident") != -1; //IE10 이전(MSIE), 이후(Trident)
		if(isMSIE) {
			//utf-8인코딩처리를 명시적으로 해줌
			resFileName = URLEncoder.encode(fileName, "UTF-8");
			//+로 처리된 공백을 다시 한 번 %20(공백의미)로 치환
			resFileName = resFileName.replaceAll("\\+", "%20");
		}else {
			resFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1"); //톰캣 기본 인코딩타입			
		}
		
		//파일전송
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+resFileName);
		
		//파일쓰기
		int read = -1;
		while((read=bis.read()) != -1) {
			bos.write(read);
		}
		bos.close();
		bis.close();
	}
	
	@RequestMapping("/admin/deleteEvent.do")
	public ModelAndView deleteEvent(@RequestParam("eventNo") int eventNo, HttpServletRequest request, ModelAndView mav){
		
		Event e = adminService.eventView(eventNo);
		int result = adminService.deleteEvent(eventNo);

		String loc = "/admin/eventList.do";
		String msg = "";
		
		if(result>0) {
			String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload/event");
			File eventSmall = new File(saveDirectory+"/"+e.getEventSmall());
			File eventBig = new File(saveDirectory+"/"+e.getEventBig());
			System.out.println(eventSmall+"/"+eventBig);
			eventSmall.delete();
			eventBig.delete();
			msg = "이벤트 삭제 성공";
		}
		else {
			msg = "이벤트 삭제 실패";
		}
		
		mav.addObject("msg", msg);
		mav.addObject("loc", loc);
		mav.setViewName("common/msg");
		
		return mav;
	}
	
}
