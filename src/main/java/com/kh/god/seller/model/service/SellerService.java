package com.kh.god.seller.model.service;

import java.util.List;

import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface SellerService {

	List<StoreInfo> myStore(String sellerId);

}
