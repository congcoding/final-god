package com.kh.god.seller.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.god.admin.model.vo.Ad;
import com.kh.god.menu.model.vo.Menu;
import com.kh.god.seller.model.vo.OrderInfo;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.MenuAttachment;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface SellerDao {

	Seller selectOneSeller(String sellerId);
	
	int insertSeller(Seller s);
	
	List<StoreInfo> myStore(String sellerId);

	int updatePwd(String password);

	int updateSeller(Seller s);

	List<Menu> myStoreMenu(String sellerId);

	List<Map<String, Object>> getStoreInfoBystoreNo(String storeNo);

	List<MenuAttachment> getAttachment(String storeNo);

	List<MenuAttachment> getthumbAttachment(String storeNo);

	int oldThumbNail(String nowThumb);

	int changeThmbNail(String newThumb);

	int updateStoreInfo(Map<String, Object> map);

	List<OrderInfo> myStoreOrderInfo(String storeNo);

	List<Menu> selectMenuList(String storeNo);

	int updateSoldout(String menuCode);

	List<Map<String, Object>> orderList1(String storeNo);

	List<Map<String, String>> adSelectAll(int cPage, int numPerPage, String storeNo);

	List<Map<String, String>> adSelectNow(int cPage, int numPerPage, String storeNo);

	List<Map<String, String>> adSelectPast(int cPage, int numPerPage, String storeNo);

	int countAdNow(String storeNo);

	int countAdAll(String storeNo);

	int countAdPast(String storeNo);

	int adRequest(Ad ad);

}
