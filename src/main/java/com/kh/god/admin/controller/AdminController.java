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
	public String askingList(@RequestParam(value="cPage",defaultValue="1") int cPage,@RequestParam(value="boardWriter") String boardWriter, Model model) {
		int numPerPage = 5;
		List<Map<String,String>> list = null;
		int totalContents = 0;
		
		list = adminService.selectQNAList(cPage,numPerPage,boardWriter);
		totalContents = adminService.countQNAList(boardWriter);
	
		List<QnaBoard> boardRefList = adminService.boardRefList();
		
		model.addAttribute("cPage",cPage);
		model.addAttribute("numPerPage",numPerPage);
		model.addAttribute("list",list);
		model.addAttribute("boardRefList",boardRefList);
		model.addAttribute("totalContents",totalContents);
		return "admin/askingList";
	}
	

	@RequestMapping("/admin/askingForm.do")
	public String askingForm(Model model, @RequestParam(value="boardWriter") String boardWriter) {
		
		model.addAttribute("boardWriter",boardWriter);
		
		return "admin/askingForm";
	}
	
	@RequestMapping("/admin/insertAsking.do")
	public ModelAndView insertAsking(@RequestParam(name="boardTitle") String boardTitle,@RequestParam(name="boardWriter") String boardWriter, @RequestParam(name="boardContent") String boardContent, ModelAndView mav) {
		QnaBoard board = new QnaBoard();
		board.setBoardTitle(boardTitle);
		board.setBoardWriter(boardWriter);
		board.setBoardContent(boardContent);
		
		int result = adminService.insertAsking(board);
		
		String msg = "";
		if(result>0) {
			msg="문의를 완료하였습니다!";
		}else {
			msg = "문의 실패ㅠ";
		}
		
		mav.addObject("msg",msg);
		mav.addObject("loc","/admin/askingList.do?boardWriter="+boardWriter);
		mav.setViewName("common/msg");
		
		return mav;
	}
	
	@RequestMapping("/admin/askingView.do")
	public String askingView(@RequestParam(name="boardNo") int boardNo, Model model) {
		QnaBoard b = adminService.qnaBoardView(boardNo);
		List<QnaBoard> boardRefList = adminService.boardRefList();
		model.addAttribute("board",b);
		model.addAttribute("boardRefList",boardRefList);
		return "admin/askingView";
	}
	
	@RequestMapping("/admin/answeringView.do")
	public String asnweringView(@RequestParam(name="boardNo") int boardNo,@RequestParam(name="boardRef") int boardRef, Model model) {
		QnaBoard b = adminService.qnaBoardView(boardRef);
		QnaBoard bRef = adminService.qnaBoardRefView(boardNo);
		logger.debug(b);
		logger.debug(bRef);
		
		model.addAttribute("board",b);
		model.addAttribute("boardRef",bRef);
		return "admin/answeringView";
	}
	
	@RequestMapping("/admin/memberList.do")
	public String memberList(@RequestParam(value="cPage",defaultValue="1") int cPage,Model model) {
		
		int numPerPage = 6;
		
		List<Map<String,String>> member = adminService.selectMemberAllList(cPage,numPerPage);
		
		int totalContents = adminService.countMemberList();
		
		model.addAttribute("cPage",cPage);
		model.addAttribute("numPerPage",numPerPage);
		model.addAttribute("member",member);
		model.addAttribute("totalContents",totalContents);
		
		return "admin/memberList";
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
	
	@RequestMapping("/admin/updateEvent.do")
	public String updateEvent(@RequestParam("eventNo") int eventNo, Model model){
		Event e = adminService.eventView(eventNo);
		model.addAttribute("event", e);
		return "admin/eventUpdate";
	}
	
	@RequestMapping("/admin/updateEventEnd.do")
	public ModelAndView updateEvent(@RequestParam(name="eventNo") int eventNo, @RequestParam(name="eventTitle") String eventTitle,
			@RequestParam(name="amount") int amount, @RequestParam(name="startDate") Date startDate, @RequestParam(name="endDate") Date endDate,
			@RequestParam(name="discount") String discount, @RequestParam(name="eventSmall") String eventSmall, @RequestParam(name="eventBig") String eventBig,
			@RequestParam(name="upFile",required=false) MultipartFile[] upFiles, HttpServletRequest request, ModelAndView mav) {

		String saveDirectory = request.getSession().getServletContext().getRealPath("/resources/upload/event");
		String rSmall = eventSmall;
		String rBig = eventBig;
		
		if(!upFiles[0].getOriginalFilename().equals("")) {
			String oSmall = upFiles[0].getOriginalFilename();
			rSmall = Utils.getRenamedEventFileName(oSmall,"s",eventNo);
			try {
				upFiles[0].transferTo(new File(saveDirectory+"/"+rSmall));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}	
		}
		
		if(!upFiles[1].getOriginalFilename().equals("")) {
			String oBig = upFiles[1].getOriginalFilename();
			rBig = Utils.getRenamedEventFileName(oBig,"b",eventNo);
			try {
				upFiles[1].transferTo(new File(saveDirectory+"/"+rBig));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		Event event = new Event();
		event.setEventNo(eventNo);
		event.setEventTitle(eventTitle);
		event.setDiscount(discount);
		event.setAmount(amount);
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		event.setEventBig(rBig);
		event.setEventSmall(rSmall);
		
		int result = adminService.updateEvent(event);
		
		//view
		
		String msg = "";
		if(result>0) {
			msg="이벤트 수정 성공";
		}else {
			msg = "이벤트 수정 실패";
		}
		
		mav.addObject("msg",msg);
		mav.addObject("loc","/admin/eventView.do?eventNo="+eventNo);
		mav.setViewName("common/msg");
		
		return mav;

	}
	
	@RequestMapping("/admin/storePMSList.do")
	public String storePMSList(@RequestParam(value="cPage", defaultValue="1") int cPage, Model model) {
		
		int numPerPage = 10;
		List<Map<String,String>> list = adminService.storePMSList(cPage, numPerPage);
		int totalContents = adminService.countStorePMSList();
		
		model.addAttribute("cPage",cPage);
		model.addAttribute("numPerPage",numPerPage);
		model.addAttribute("totalContents",totalContents);
		model.addAttribute("list",list);
		
		return "/admin/storePMSList";
	}
	
	@RequestMapping("/admin/storeList.do")
	public String storeList(@RequestParam(value="cPage", defaultValue="1") int cPage, Model model) {
		
		int numPerPage = 10;
		List<Map<String,String>> list = adminService.storeList(cPage, numPerPage);
		int totalContents = adminService.countStoreList();
		
		model.addAttribute("cPage",cPage);
		model.addAttribute("numPerPage",numPerPage);
		model.addAttribute("totalContents",totalContents);
		model.addAttribute("list",list);
		
		return "/admin/storeList";
	}
	
}
