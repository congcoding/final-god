package com.kh.god.seller.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.menu.model.vo.Menu;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.MenuAttachment;
import com.kh.god.storeInfo.model.vo.StoreInfo;

@Repository
public class SellerDaoImpl implements SellerDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public Seller selectOneSeller(String sellerId) {
		Seller s = sqlSession.selectOne("seller.selectOneSeller", sellerId);
		return s;
	}

	@Override
	public int insertSeller(Seller s) {
		return sqlSession.insert("seller.insertSeller", s);
	}

	public List<StoreInfo> myStore(String sellerId) {

		return sqlSession.selectList("storeInfo.getMyStore", sellerId);
	}

	@Override
	public List<Menu> myStoreMenu(String sellerId) {
		return sqlSession.selectList("storeInfo.myStoreMenu", sellerId);
	}

	@Override
	public List<Map<String, Object>> getStoreInfoBystoreNo(String storeNo) {
		return sqlSession.selectList("storeInfo.storeInfoList", storeNo);
	}


	@Override
	public List<MenuAttachment> getAttachment(String storeNo) {
		System.out.println("@@@@@@storeNo="+storeNo);
		return sqlSession.selectList("storeInfo.getAttachment",storeNo);
	}

	@Override
	public List<MenuAttachment> getthumbAttachment(String storeNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("storeInfo.getthumbAttachment",storeNo);
	}



}
