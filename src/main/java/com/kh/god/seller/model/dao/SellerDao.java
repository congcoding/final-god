package com.kh.god.seller.model.dao;

import java.util.List;

import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface SellerDao {

	List<StoreInfo> myStore(String sellerId);

}
