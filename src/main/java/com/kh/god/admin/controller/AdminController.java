package com.kh.god.admin.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.god.admin.model.service.AdminService;
import com.kh.god.admin.model.vo.QnaBoard;

@Controller
public class AdminController {
	
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
}
