package com.kh.god.payment.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class paymentController {

	Logger logger = Logger.getLogger(getClass());

	
	@RequestMapping("/payment/goPaymentPage.do")
	public String goPaymentPage(Model model,
			@RequestParam("menuName") String menuName,
			@RequestParam("menuCode") String menuCode,
			@RequestParam("menuPrice") String menuPrice) {
		
		
		return "payment/paymentPreparations";
	}
}
