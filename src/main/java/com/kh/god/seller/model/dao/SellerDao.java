package com.kh.god.seller.model.dao;

import com.kh.god.seller.model.vo.Seller;

public interface SellerDao {

	Seller selectOneSeller(String sellerId);

	int insertSeller(Seller s);

}
