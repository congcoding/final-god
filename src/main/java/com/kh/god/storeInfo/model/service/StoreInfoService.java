package com.kh.god.storeInfo.model.service;

import java.util.List;
import java.util.Map;

import com.kh.god.storeInfo.model.vo.SAttachment;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface StoreInfoService {

	int selectStoreInfoTotalContents(int categoryNo);

	List<Map<String, String>> selectStoreInfoList(int cPage, int numPerPage, int categoryNo);

	int addStore(StoreInfo s, List<SAttachment> attachList);

}
