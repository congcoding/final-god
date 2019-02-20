package com.kh.god.seller.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.god.menu.model.vo.Menu;
import com.kh.god.seller.model.vo.OrderInfo;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.MenuAttachment;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface SellerService {

	Seller selectOneSeller(String sellerId);

	int insertSeller(Seller s);
	
	List<StoreInfo> myStore(String sellerId);
	
	List<Menu> myStoreMenu(String sellerId);

	List<Map<String, Object>> getStoreInfoBystoreNo(String storeNo);

	List<MenuAttachment> getAttachment(String storeNo);

	List<MenuAttachment> getthumbAttachment(String storeNo);

	int oldThumbNail(String nowThumb);

	int changeThmbNail(String newThumb);

	int updateStoreInfo(Map<String, Object> map);

	List<OrderInfo> myStoreOrderInfo(String storeNo);
	
	int updatePwd(String password);

	int updateSeller(Seller seller);

	List<StoreInfo> selectListStorInfo(String sellerId);

	List<Menu> selectMenuList(String storeNo);

	int updateSoldout(Map<String, Object> map);

	List<Map<String, Object>> orderList1(String storeNo);

}
