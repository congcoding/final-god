package com.kh.god.seller.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface SellerDao {

	Seller selectOneSeller(String sellerId);
	
	int insertSeller(Seller s);
	
	List<StoreInfo> myStore(String sellerId);

	List<Map<String, Object>> getStoreInfoBystoreNo(String storeNo);

}
