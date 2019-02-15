package com.kh.god.menu.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.god.menu.model.service.MenuService;

@Controller
public class MenuController {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	MenuService menuService;

	@RequestMapping("/menu/menuList.do")
	public ModelAndView menuList(@RequestParam(value = "storeNo") String storeNo, ModelAndView mav) {
		
		System.out.println("storeNo = " + storeNo);
		
		if(logger.isDebugEnabled()) {
			logger.debug("매장 메뉴 페이지");
		}
		
		return mav;
		
	}
	
}
