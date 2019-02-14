package com.kh.god.seller.model.dao;

import java.util.List;

import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface SellerDao {

	Seller selectOneSeller(String sellerId);
	
	int insertSeller(Seller s);
	
	List<StoreInfo> myStore(String sellerId);

}
