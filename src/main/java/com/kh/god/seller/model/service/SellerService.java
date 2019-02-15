package com.kh.god.seller.model.service;

import java.util.List;

import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface SellerService {

	Seller selectOneSeller(String sellerId);

	int insertSeller(Seller s);
	
	List<StoreInfo> myStore(String sellerId);

}