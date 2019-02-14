package com.kh.god.seller.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.StoreInfo;


@Repository
public class SellerDaoImpl implements SellerDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public Seller selectOneSeller(String sellerId) {
		Seller s =  sqlSession.selectOne("seller.selectOneSeller" , sellerId);
		return s ;
	}

	@Override
	public int insertSeller(Seller s) {
		return sqlSession.insert("seller.insertSeller" , s);
	}
	
	public List<StoreInfo> myStore(String sellerId) {
		
		return sqlSession.selectList("storeInfo.getMyStore", sellerId);
	}

}
