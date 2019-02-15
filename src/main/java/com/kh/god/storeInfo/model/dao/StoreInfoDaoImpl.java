package com.kh.god.storeInfo.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreInfoDaoImpl implements StoreInfoDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<Map<String, String>> selectStoreInfoList(int cPage, int numPerPage, int categoryNo) {
		RowBounds rowBounds = new RowBounds((cPage-1) * numPerPage, numPerPage);
		return sqlSession.selectList("storeInfo.selectStoreInfoList", categoryNo, rowBounds);
	}

	@Override
	public int selectStoreInfoTotalContents(int categoryNo) {
		return sqlSession.selectOne("storeInfo.selectStoreInfoTotalContents", categoryNo);
	}

}
