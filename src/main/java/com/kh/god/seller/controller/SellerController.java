package com.kh.god.seller.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.god.seller.model.service.SellerService;
import com.kh.god.storeInfo.model.vo.StoreInfo;

@Controller
@SessionAttributes(value = {"memberLoggedIn"})
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
	
	//내 가게 
	@RequestMapping("/seller/goMyShop.do")
	public String goMyShop(@RequestParam("sellerId") String sellerId,Model model ) {
		List<StoreInfo> store = sellerService.myStore(sellerId);

		//메뉴 뽑기
		//페이지바 만들기
		model.addAttribute("store", store);
		//model.addAttribute("menu", menu);

		
		return "seller/goMyStore";
	}

}
