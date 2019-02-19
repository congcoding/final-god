package com.kh.god.menu.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.god.menu.model.service.MenuService;
import com.kh.god.menu.model.vo.Menu;
import com.kh.god.storeInfo.model.vo.StoreInfo;

@Controller
public class MenuController {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	MenuService menuService;

	@RequestMapping("/menu/menuList.do")
	public String menuList(@RequestParam(value = "storeNo") String storeNo, Model model) {
		
		
		if(logger.isDebugEnabled()) {
			logger.debug("매장 메뉴 페이지");
		}
		
		List<Menu> menuList = menuService.menuList(storeNo);
		List<StoreInfo> storeInfo = menuService.storeInfoList(storeNo);
		int menuTotalCount = menuService.menuCount(storeNo);
		model.addAttribute("menuTotalCount",menuTotalCount);
		model.addAttribute("menuList",menuList);
		model.addAttribute("storeInfo",storeInfo);
		System.out.println("@@@"+storeInfo);
		return "storeInfo/MenuListByStore";	
	}
	

}
