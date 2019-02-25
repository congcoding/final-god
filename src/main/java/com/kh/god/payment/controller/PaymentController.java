package com.kh.god.payment.controller;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.god.common.message.MessageSend;
import com.kh.god.seller.model.service.SellerService;
import com.siot.IamportRestHttpClientJava.request.CancelData;
import com.siot.IamportRestHttpClientJava.response.IamportResponse;
import com.siot.IamportRestHttpClientJava.response.Payment;

@Controller
public class PaymentController {
	IamportClient client;
	
	@Autowired
	SellerService sellerService;
	
	Logger logger = Logger.getLogger(getClass());

	
	public void setup() throws Exception {
		String api_key = "3227163481491035";
		String api_secret = "TLsxAneWAtIMa2g1cHYnLmXbnyZYJRBCD4aerpa2STO2W548M2wxptJM1ILLAnndryrSXCVPvJSrOXAA";

		client = new IamportClient(api_key, api_secret);
	}
	
	
	//결제준비페이지
	@RequestMapping("/payment/goPaymentPage.do")
	public String goPaymentPage(@RequestParam("storeName") String storeName,
			@RequestParam("storeNo") String storeNo
			,Model model) {
		System.out.println(storeName);
		System.out.println("여기에 나오면돼요 흙흙"+storeNo);
		model.addAttribute("storeName",storeName);
		model.addAttribute("storeNo",storeNo);

		return "payment/paymentPreparations";
	}
	
	
	//결제완료시
	@RequestMapping("/payment/paymentEnd.do")
	public String paymentEnd(@RequestParam("paymentId") String paymentId) {
		System.out.println("@@@페이먼트아이디"+paymentId);		
		//int putPaymentId = paymentService.putPaymentId(paymentId);
		return "payment/paymentEnd";
	}
	
	//결제취소
	@RequestMapping("/payment/paymentCancel.do")
	@ResponseBody
	public void testCancelPaymentByImpUid(@RequestParam("paymentId") String impUid,
			 @RequestParam("orderNoForCancel") int orderNo,
	         @RequestParam("reason") String reason,
	         @RequestParam(value="cancelReason", required=false) String cancelReason,
	         @RequestParam("memberPhoneForCancel") String memberPhoneForCancel,
	         @RequestParam("priceWay") String priceWay) throws Exception {
		setup();
		//이미 취소된 거래 imp_uid paymentId
		if(priceWay.equals("Y")) {
			CancelData cancel1 = new CancelData(impUid, true);
			IamportResponse<Payment> cancelpayment1 = client.cancelPayment(cancel1);
			System.out.println(cancelpayment1.getMessage());
		} 
		if(reason.equals("기타")) {
			reason = "기타:" + cancelReason;
		}
		MessageSend ms = new MessageSend();
		String flag = "cancel";
		//ms.main(reason,memberPhoneForCancel,flag);

		int result = sellerService.cancelOrder(orderNo);	

	}
}
