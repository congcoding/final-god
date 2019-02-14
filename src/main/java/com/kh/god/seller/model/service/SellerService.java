package com.kh.god.seller.model.service;

import com.kh.god.seller.model.vo.Seller;

public interface SellerService {

	Seller selectOneSeller(String sellerId);

	int insertSeller(Seller s);

}
