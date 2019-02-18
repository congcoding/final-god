package com.kh.god.seller.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.menu.model.vo.Menu;
import com.kh.god.seller.model.dao.SellerDao;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.Attachment;
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
	
	public List<StoreInfo> myStore(String sellerId) {
		List<StoreInfo> store = sellerDao.myStore(sellerId);
		return store;
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
	public List<Attachment> getAttachment(String storeNo) {
		// TODO Auto-generated method stub
		return sellerDao.getAttachment(storeNo);
	}



	
}
