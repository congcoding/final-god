package com.kh.god.seller.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SellerDaoImpl implements SellerDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	

}
