package com.kh.god.storeInfo.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.god.storeInfo.model.vo.SAttachment;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface StoreInfoDao {

	List<Map<String, String>> selectStoreInfoList(int cPage, int numPerPage, int categoryNo);

	int selectStoreInfoTotalContents(int categoryNo);

	int addStore(StoreInfo s);

	int insertAttachment(SAttachment a);



}
