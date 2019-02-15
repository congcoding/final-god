package com.kh.god.admin.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.admin.model.vo.Event;
import com.kh.god.admin.model.vo.QnaBoard;
import com.kh.god.seller.model.vo.Seller;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<Map<String, String>> selectBoardList(int cPage, int numPerPage) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("admin.selectBoardList",null,rowBounds);
	}

	@Override
	public int countBoardList() {
		return sqlSession.selectOne("admin.countBoardList");
	}

	@Override
	public List<Map<String, String>> selectEventList(int cPage, int numPerPage) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("admin.selectEventList",null,rowBounds);
	}

	@Override
	public int countEventList() {
		return sqlSession.selectOne("admin.countEventList");
	}

	@Override
	public int getLastEventNo() {
		return sqlSession.selectOne("admin.getLastEventNo");
	}

	@Override
	public int insertEvent(Event event) {
		return sqlSession.insert("admin.insertEvent",event);
	}

	@Override
	public QnaBoard qnaBoardView(int boardNo) {
		return sqlSession.selectOne("admin.qnaBoardView",boardNo);
	}

	@Override
	public List<Map<String, String>> selectSellerAllList(int cPage, int numPerPage) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("admin.selectSellerAllList",null,rowBounds);
	}

	@Override
	public int countSellerList() {
		return sqlSession.selectOne("admin.countSellerList");
	}

	@Override
	public Event eventView(int eventNo) {
		return sqlSession.selectOne("admin.eventView", eventNo);
	}
	
	public int changeSellerbFlagtoN(String sellerId) {
		return sqlSession.update("admin.changeSellerbFlagtoN",sellerId);
	}

	@Override
	public int changeSellerbFlagtoY(String sellerId) {
		return sqlSession.update("admin.changeSellerbFlagtoY",sellerId);
	}

	@Override
	public List<Map<String, String>> selectMemberQNAList(int cPage, int numPerPage, String memberId) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("admin.selectMemberQNAList",memberId,rowBounds);
	}

	@Override
	public int countMemberQNAList(String memberId) {
		return sqlSession.selectOne("admin.countMemberQNAList",memberId);
	}

	@Override
	public List<Map<String, String>> selectSellerQNAList(int cPage, int numPerPage, String sellerId) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("admin.selectSellerQNAList",sellerId,rowBounds);
	}

	@Override
	public int countSellrQNAList(String sellerId) {
		return sqlSession.selectOne("admin.countSellerQNAList",sellerId);
	}
	

}
