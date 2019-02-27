package com.kh.god.seller.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.god.admin.model.vo.Ad;
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
	
	int updatePwd(Seller s);

	int updateSeller(Seller seller);

	List<StoreInfo> selectListStorInfo(String sellerId);

	List<Menu> selectMenuList(String storeNo);

	int updateSoldout(Map<String, Object> map);

	List<Map<String, Object>> orderList1(String storeNo);


	List<Map<String, String>> adSelectAll(int cPage, int numPerPage, String storeNo);

	List<Map<String, String>> adSelectNow(int cPage, int numPerPage, String storeNo);

	List<Map<String, String>> adSelectPast(int cPage, int numPerPage, String storeNo);

	int countAdAll(String storeNo);

	int countAdNow(String storeNo);

	int countAdPast(String storeNo);

	int adRequest(Ad ad);

	int receiveOrder(Map<String, Object> map);

	List<Map<String, Object>> orderList2(String storeNo);

	List<Map<String, Object>> orderList3(String storeNo);

	int deliveryEnd(int orderNo);

	int cancelOrder(int orderNo);

	int updateMenu(Map<String, Object> map);

	int deleteMenu(String menuCode);

	int insertOrder(Map<String, Object> map);

	int insertOrderInfo(Map<String, Object> orderInfoMap);

	int insertOrderMenu(Map<String, Object> orderMenuMap);

	List<Map<String, String>> totalSaleVolume(String sellerId,String type);


	int selectMenuNo(String storeNo);

	int insertMenu(Menu menu);

	StoreInfo selectStoreInfo(String storeNo);

	List<Map<String, String>> totalSaleVolume(String sellerId, String storeNo, String string);




}
