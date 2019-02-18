package com.kh.god.seller.model.service;

import java.util.List;
import java.util.Map;

import com.kh.god.menu.model.vo.Menu;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface SellerService {

	Seller selectOneSeller(String sellerId);

	int insertSeller(Seller s);
	
	List<StoreInfo> myStore(String sellerId);
	
	List<Menu> myStoreMenu(String sellerId);

	List<Map<String, Object>> getStoreInfoBystoreNo(String storeNo);


}
