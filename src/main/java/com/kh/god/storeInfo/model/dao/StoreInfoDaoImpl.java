package com.kh.god.storeInfo.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.storeInfo.model.vo.SAttachment;
import com.kh.god.storeInfo.model.vo.StoreInfo;

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

	@Override
	public int addStore(StoreInfo s) {
		return sqlSession.insert("storeInfo.addStore" , s);
	}

	@Override
	public int insertAttachment(SAttachment a ) {
		return sqlSession.insert("storeInfo.insertAttachment" , a );
	}

	@Override
	public StoreInfo selectOnebyStoreNo(String storeNo) {
		return sqlSession.selectOne("storeInfo.selectOnebyStoreNo" , storeNo);
	}

	@Override
	public List<Map<String, String>> selectAttchMentLsit(String storeNo) {
		return sqlSession.selectList("storeInfo.selectAttchMentLsit" , storeNo);
	}

	@Override
	public int deleteFile1(String filename) {
		return sqlSession.update("storeInfo.deleteFile1" , filename);
	}

	@Override
	public int updateStore(StoreInfo s) {
		return sqlSession.update("storeInfo.updateStore" , s);
	}

	@Override
	public int closedStore(String storeNo) {
		return sqlSession.update("storeInfo.closedStore", storeNo);
	}

	@Override
	public List<Map<String, String>> totalSaleVolume(String sellerId,String type) {
		List<Map<String,String>> resultList = null;
		switch(type) {
		case "today" : resultList = new ArrayList<>();resultList = sqlSession.selectList("storeInfo.totalSaleVolumeofToday", sellerId); break;
		case "week" : resultList = new ArrayList<>(); resultList = sqlSession.selectList("storeInfo.totalSaleVolumeofWeek", sellerId); break;
		case "month" : resultList = new ArrayList<>(); resultList = sqlSession.selectList("storeInfo.totalSaleVolumeofMonth", sellerId); break;
		case "3month" : resultList = new ArrayList<>(); resultList = sqlSession.selectList("storeInfo.totalSaleVolumeof3Month", sellerId); break;
		}
		
		return resultList;
	}
	

	

}
