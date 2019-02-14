package com.kh.god.seller.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.seller.model.dao.SellerDao;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerDao sellerDao;
	
	
	
	
}
