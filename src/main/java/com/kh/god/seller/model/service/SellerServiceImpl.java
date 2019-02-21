package com.kh.god.seller.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.admin.model.vo.Ad;
import com.kh.god.menu.model.vo.Menu;
import com.kh.god.seller.model.dao.SellerDao;
import com.kh.god.seller.model.vo.OrderInfo;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.MenuAttachment;
import com.kh.god.storeInfo.model.vo.StoreInfo;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	SellerDao sellerDao;

	@Override
	public Seller selectOneSeller(String sellerId) {
		return sellerDao.selectOneSeller(sellerId);
	}

	@Override
	public int insertSeller(Seller s) {
		return sellerDao.insertSeller(s);
	}
	
	@Override
	public List<StoreInfo> myStore(String sellerId) {
		List<StoreInfo> store = sellerDao.myStore(sellerId);
		return store;
	}

	@Override
	public int updatePwd(String password) {
		return sellerDao.updatePwd(password);
	}

	@Override
	public int updateSeller(Seller s) {
		return sellerDao.updateSeller(s);
	}
	
	@Override
	public List<Menu> myStoreMenu(String sellerId) {
		List<Menu> menu = sellerDao.myStoreMenu(sellerId);
		return menu;
	}

	@Override
	public List<Map<String, Object>> getStoreInfoBystoreNo(String storeNo) {
		List<Map<String, Object>> getStoreInfoBystoreNo = sellerDao.getStoreInfoBystoreNo(storeNo);
		return getStoreInfoBystoreNo;
	}

	@Override

	public List<MenuAttachment> getAttachment(String storeNo) {
		return sellerDao.getAttachment(storeNo);
	}

	@Override
	public List<Menu> selectMenuList(String storeNo) {
		
		return sellerDao.selectMenuList(storeNo);
	}

	public List<MenuAttachment> getthumbAttachment(String storeNo) {
		return sellerDao.getthumbAttachment(storeNo);
	}

	@Override
	public int oldThumbNail(String nowThumb) {
		return sellerDao.oldThumbNail(nowThumb);	
    }

	@Override
	public int changeThmbNail(String newThumb) {
		return sellerDao.changeThmbNail(newThumb);
	}

	@Override
	public int updateStoreInfo(Map<String, Object> map) {
		return sellerDao.updateStoreInfo(map);
	}
	
	@Override
	public int updateSoldout(Map<String, Object> map) {
		return sellerDao.updateSoldout(map);
	}
	
	@Override
	public List<StoreInfo> selectListStorInfo(String sellerId) {
		return sellerDao.selectListStorInfo(sellerId);
	}

	public List<OrderInfo> myStoreOrderInfo(String storeNo) {
		// TODO Auto-generated method stub
		return sellerDao.myStoreOrderInfo(storeNo);
	}

	@Override
	public List<Map<String, Object>> orderList1(String storeNo) {
		// TODO Auto-generated method stub
		return sellerDao.orderList1(storeNo);
	}

	@Override
	public List<Map<String, String>> adSelectAll(int cPage, int numPerPage,String storeNo) {
		return sellerDao.adSelectAll(cPage,numPerPage,storeNo);
	}

	@Override
	public List<Map<String, String>> adSelectNow(int cPage, int numPerPage,String storeNo) {
		return sellerDao.adSelectNow(cPage,numPerPage,storeNo);
	}

	@Override
	public List<Map<String, String>> adSelectPast(int cPage, int numPerPage,String storeNo) {
		return sellerDao.adSelectPast(cPage,numPerPage,storeNo);
	}

	@Override
	public int countAdAll(String storeNo) {
		return sellerDao.countAdAll(storeNo);
	}

	@Override
	public int countAdNow(String storeNo) {
		return sellerDao.countAdNow(storeNo);
	}

	@Override
	public int countAdPast(String storeNo) {
		return sellerDao.countAdPast(storeNo);
	}

	@Override
	public int adRequest(Ad ad) {
		return sellerDao.adRequest(ad);
	}
	
	public int receiveOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sellerDao.receiveOrder(map);
	}

	@Override
	public List<Map<String, Object>> orderList2(String storeNo) {
		// TODO Auto-generated method stub
		return sellerDao.orderList2(storeNo);
	}

	@Override
	public List<Map<String, Object>> orderList3(String storeNo) {
		// TODO Auto-generated method stub
		return sellerDao.orderList3(storeNo);
	}

	@Override
	public int deliveryEnd(int orderNo) {
		// TODO Auto-generated method stub
		return sellerDao.deliveryEnd(orderNo);
	}

	@Override
	public int updateMenu(Map<String, Object> map) {
		return sellerDao.updateMenu(map);
	}

	@Override
	public int deleteMenu(String menuCode) {
		return sellerDao.deleteMenu(menuCode);
	}

	
}
