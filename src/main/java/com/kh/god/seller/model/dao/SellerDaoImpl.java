package com.kh.god.seller.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.menu.model.vo.Menu;
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

	@Override
	public List<Map<String, String>> myStoreMenu(int cPage, int numPerPage, String sellerId) {
		RowBounds rowBounds = new RowBounds((cPage-1) * numPerPage, numPerPage);
		return sqlSession.selectList("storeInfo.myStoreMenu", sellerId, rowBounds);
	}

	@Override
	public int selectSellerMenuTotalContents(String sellerId) {
		return sqlSession.selectOne("storeInfo.selectSellerMenuTotalContents", sellerId);
	}


}
