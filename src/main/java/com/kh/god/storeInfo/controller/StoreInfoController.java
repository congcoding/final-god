package com.kh.god.storeInfo.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kh.god.storeInfo.model.service.StoreInfoService;

@Controller
public class StoreInfoController {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	StoreInfoService storeInfoService;
	
	@RequestMapping("/storeInfo/storeInfoList.do")
	public ModelAndView storeInfoList(@RequestParam(value = "cPage", defaultValue = "1") int cPage, 
								  @RequestParam(value = "categoryNo") int categoryNo, 
								  ModelAndView mav) {
		
		System.out.println("categoryNo = " + categoryNo);
		
		if(logger.isDebugEnabled()) {
			logger.debug("매장 목록페이지");
		}
		
		int numPerPage = 6;
		
		// 업무로직
		// 1. 게시글리스트 (페이징 적용된 것)
		System.out.println(cPage);
		List<Map<String, String>> list = storeInfoService.selectStoreInfoList(cPage, numPerPage, categoryNo);

		// 2. 전체컨텐츠수
		int totalContents = storeInfoService.selectStoreInfoTotalContents(categoryNo);
		
		mav.addObject("list", list);
		mav.addObject("categoryNo", categoryNo);
		mav.addObject("cPage", cPage);
		mav.addObject("numPerPage", numPerPage);
		mav.addObject("totalContents", totalContents);

		mav.setViewName("storeInfo/storeInfoList");

		return mav;
	}
	
	
}
