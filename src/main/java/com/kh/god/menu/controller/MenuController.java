package com.kh.god.menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.god.member.model.service.MemberService;
import com.kh.god.member.model.vo.Member;
import com.kh.god.menu.model.service.MenuService;
import com.kh.god.menu.model.vo.Menu;
import com.kh.god.storeInfo.model.vo.StoreInfo;

@Controller
public class MenuController {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	MenuService menuService;
	
	@Autowired
	MemberService memberService;

	@RequestMapping("/menu/menuList.do")
	public String menuList(@RequestParam(value = "storeNo") String storeNo, 
							Model model, HttpSession session) {
		
		/*
		 * /menu/menuList.do?storeNo=${list.storeNo }"
		 */		
		 Member memberLoggedIn = null;
		 memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
		
		if(logger.isDebugEnabled()) {
			logger.debug("매장 메뉴 페이지");
		}
		
		List<Menu> menuList = menuService.menuList(storeNo);
		List<StoreInfo> storeInfo = menuService.storeInfoList(storeNo);		
		int menuTotalCount = menuService.menuCount(storeNo);
		if( memberLoggedIn != null) {
			Map<String, String> map = new HashMap<>();
			map.put("memberId", memberLoggedIn.getMemberId());
			map.put("storeNo", storeNo);
			int checkedBookMark = memberService.checkBookMark(map);			
		}
		
		
		model.addAttribute("menuTotalCount",menuTotalCount);
		model.addAttribute("menuList",menuList);
		model.addAttribute("storeInfo",storeInfo);
		
		return "storeInfo/MenuListByStore";	
	}
	
	
	@RequestMapping("/menu/selecOneMenu.do")
	@ResponseBody
	public Menu selectOneMenu(@RequestParam String menuCode) {
		Menu menu = null;
		
		menu = menuService.selectOneMenu(menuCode);
		logger.debug("Menu = " + menu);
		
		
		return menu;
	}
	
	
	
	

}
