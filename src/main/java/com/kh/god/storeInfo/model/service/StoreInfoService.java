package com.kh.god.storeInfo.model.service;

import java.util.List;
import java.util.Map;

public interface StoreInfoService {

	int selectStoreInfoTotalContents();

	List<Map<String, String>> selectStoreInfoList(int cPage, int numPerPage, int categoryNo);

}
