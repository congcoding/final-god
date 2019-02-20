package com.kh.god.seller.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.menu.model.vo.Menu;
import com.kh.god.seller.model.dao.SellerDao;
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
		return sellerDao.oldThumbNail(nowThumb);	}

	@Override
	public int changeThmbNail(String newThumb) {
		return sellerDao.changeThmbNail(newThumb);
	}

	@Override
	public int updateStoreInfo(Map<String, Object> map) {
		return sellerDao.updateStoreInfo(map);
	}

	@Override
	public int updateSoldout(String menuCode) {
		return sellerDao.updateSoldout(menuCode);
	}

	
}
