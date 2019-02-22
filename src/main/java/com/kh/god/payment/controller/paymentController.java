package com.kh.god.payment.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.god.payment.model.service.PaymentService;

@Controller
public class paymentController {

	/*
	 * @Autowired PaymentService paymentService;
	 */
	Logger logger = Logger.getLogger(getClass());

	//결제준비페이지
	@RequestMapping("/payment/goPaymentPage.do")
	public String goPaymentPage() {

		return "payment/paymentPreparations";
	}
	//결제완료시
	@RequestMapping("/payment/paymentEnd.do")
	public String paymentEnd(@RequestParam("paymentId") String paymentId) {
		//int putPaymentId = paymentService.putPaymentId(paymentId);
		return "redirect:/";
	}
}
