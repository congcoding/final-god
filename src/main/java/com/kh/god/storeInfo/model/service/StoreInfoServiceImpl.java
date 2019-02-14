package com.kh.god.storeInfo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.storeInfo.model.dao.StoreInfoDao;

@Service
public class StoreInfoServiceImpl implements StoreInfoService {
	
	@Autowired
	StoreInfoDao storeInfoDao;

	@Override
	public List<Map<String, String>> selectStoreInfoList(int cPage, int numPerPage, int categoryNo) {
		return storeInfoDao.selectStoreInfoList(cPage, numPerPage, categoryNo);
	}
	
	@Override
	public int selectStoreInfoTotalContents() {
		return storeInfoDao.selectStoreInfoTotalContents();
	}


}
