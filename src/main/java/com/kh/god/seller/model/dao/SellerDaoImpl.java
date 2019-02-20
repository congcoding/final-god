package com.kh.god.seller.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.menu.model.vo.Menu;
import com.kh.god.seller.model.vo.OrderInfo;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.MenuAttachment;
import com.kh.god.storeInfo.model.vo.StoreInfo;

@Repository
public class SellerDaoImpl implements SellerDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public Seller selectOneSeller(String sellerId) {
		Seller s = sqlSession.selectOne("seller.selectOneSeller", sellerId);
		return s;
	}

	@Override
	public int insertSeller(Seller s) {
		return sqlSession.insert("seller.insertSeller", s);
	}

	@Override
	public List<StoreInfo> myStore(String sellerId) {
		return sqlSession.selectList("storeInfo.getMyStore", sellerId);
	}

	@Override
	public int updatePwd(String password) {
		return sqlSession.update("seller.updatePwd" , password);
	}

	@Override
	public int updateSeller(Seller s) {
		return sqlSession.update("seller.updateSeller" , s);
	}
	
	@Override
	public List<Menu> myStoreMenu(String sellerId) {
		return sqlSession.selectList("storeInfo.myStoreMenu", sellerId);
	}

	@Override
	public List<Map<String, Object>> getStoreInfoBystoreNo(String storeNo) {
		return sqlSession.selectList("storeInfo.storeInfoList", storeNo);
	}

	@Override
	public List<MenuAttachment> getAttachment(String storeNo) {
		return sqlSession.selectList("storeInfo.getAttachment",storeNo);
	}

	@Override
	public List<Menu> selectMenuList(String storeNo) {
		return sqlSession.selectList("storeInfo.selectMenuList", storeNo);
	}
	
	@Override
	public List<MenuAttachment> getthumbAttachment(String storeNo) {
		return sqlSession.selectList("storeInfo.getthumbAttachment",storeNo);
	}

	@Override
	public int oldThumbNail(String nowThumb) {
		return sqlSession.update("storeInfo.oldThumbNail",nowThumb);
	}

	@Override
	public int changeThmbNail(String newThumb) {
		return sqlSession.update("storeInfo.changeThmbNail",newThumb);
	}

	@Override
	public int updateStoreInfo(Map<String, Object> map) {
		return sqlSession.update("storeInfo.updateStoreInfo",map);
	}

	@Override
	public int updateSoldout(String menuCode) {
		return sqlSession.update("storeInfo.updateSoldout", menuCode);
	}

	public List<OrderInfo> myStoreOrderInfo(String storeNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("storeInfo.myStoreOrderInfo",storeNo);
	}

	@Override
	public List<Map<String, Object>> orderList1(String storeNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("storeInfo.orderList1",storeNo);
	}

	@Override
	public int receiveOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update("storeInfo.receiveOrder",map);
	}

	@Override
	public List<Map<String, Object>> orderList2(String storeNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("storeInfo.orderList2",storeNo);
	}

	@Override
	public List<Map<String, Object>> orderList3(String storeNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("storeInfo.orderList3",storeNo);
	}

	@Override
	public int deliveryEnd(int orderNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("storeInfo.deliveryEnd",orderNo);
	}

}
