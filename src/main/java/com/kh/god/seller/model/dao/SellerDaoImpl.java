package com.kh.god.seller.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.seller.model.vo.Seller;

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
	
	
	
	
	

}
