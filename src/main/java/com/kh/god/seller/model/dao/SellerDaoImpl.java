package com.kh.god.seller.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.admin.model.vo.Ad;
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
	public int updatePwd(Seller s) {
		return sqlSession.update("seller.updatePwd" , s );
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
	public int updateSoldout(Map<String, Object> map) {
		return sqlSession.update("storeInfo.updateSoldout", map);
	}
	
	@Override
	public List<StoreInfo> selectListStorInfo(String sellerId) {
		return sqlSession.selectList("storeInfo.selectListStorInfo" , sellerId);
	}
	
	@Override
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
	public List<Map<String, String>> adSelectAll(int cPage, int numPerPage, String storeNo) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("storeInfo.adSelectAll",storeNo,rowBounds);
	}

	@Override
	public List<Map<String, String>> adSelectNow(int cPage, int numPerPage, String storeNo) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("storeInfo.adSelectNow",storeNo,rowBounds);
	}

	@Override
	public List<Map<String, String>> adSelectPast(int cPage, int numPerPage, String storeNo) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("storeInfo.adSelectPast",storeNo,rowBounds);
	}

	@Override
	public int countAdNow(String storeNo) {
		return sqlSession.selectOne("storeInfo.countAdNow",storeNo);
	}

	@Override
	public int countAdAll(String storeNo) {
		return sqlSession.selectOne("storeInfo.countAdAll",storeNo);
	}

	@Override
	public int countAdPast(String storeNo) {
		return sqlSession.selectOne("storeInfo.countAdPast",storeNo);
	}

	@Override
	public int adRequest(Ad ad) {
		return sqlSession.insert("storeInfo.adRequest",ad);
	}

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

	@Override
	public int cancelOrder(int orderNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("storeInfo.cancelOrder",orderNo);
	}

	public int updateMenu(Map<String, Object> map) {
		return sqlSession.update("menu.updateMenu", map);
	}

	@Override
	public int deleteMenu(String menuCode) {
		return sqlSession.delete("menu.deleteMenu", menuCode);
	}


}
