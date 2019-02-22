package com.kh.god.payment.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class paymentController {

	/*
	 * @Autowired PaymentService paymentService;
	 */
	Logger logger = Logger.getLogger(getClass());

	//결제준비페이지
	@RequestMapping("/payment/goPaymentPage.do")
	public String goPaymentPage(@RequestParam("storeName") String storeName,Model model) {
		
		System.out.println(storeName);
		model.addAttribute("storeName",storeName);
		
		return "payment/paymentPreparations";
	}
	
	
	//결제완료시
	@RequestMapping("/payment/paymentEnd.do")
	public String paymentEnd(@RequestParam("paymentId") String paymentId) {
		//int putPaymentId = paymentService.putPaymentId(paymentId);
		return "redirect:/";
	}
}
