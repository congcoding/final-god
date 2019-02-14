package com.kh.god.seller.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.god.seller.model.service.SellerService;

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
	

}
