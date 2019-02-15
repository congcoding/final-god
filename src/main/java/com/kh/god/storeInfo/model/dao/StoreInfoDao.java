package com.kh.god.storeInfo.model.dao;

import java.util.List;
import java.util.Map;

public interface StoreInfoDao {

	List<Map<String, String>> selectStoreInfoList(int cPage, int numPerPage, int categoryNo);

	int selectStoreInfoTotalContents(int categoryNo);


}
