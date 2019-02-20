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
	public int insertAsking(QnaBoard board) {
		return sqlSession.insert("admin.insertAsking",board);
	}

	@Override
	public List<Map<String, String>> selectQNAList(int cPage, int numPerPage, String boardWriter) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("admin.selectQNAList",boardWriter,rowBounds);
	}

	@Override
	public int countQNAList(String boardWriter) {
		return sqlSession.selectOne("admin.countQNAList",boardWriter);
	}

	@Override
	public List<QnaBoard> boardRefList() {
		return sqlSession.selectList("admin.boardRefList");
	}

	@Override
	public QnaBoard qnaBoardRefView(int boardNo) {
		return sqlSession.selectOne("admin.qnaBoardRefView",boardNo);
	}

	@Override
	public int countMemberList() {
		return sqlSession.selectOne("admin.countMemberList");
	}

	@Override
	public List<Map<String, String>> selectMemberAllList(int cPage, int numPerPage) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("admin.selectMemberAllList",null,rowBounds);
	}

	@Override
	public int deleteEvent(int eventNo) {
		return sqlSession.delete("admin.deleteEvent", eventNo);
	}

	@Override
	public int updateEvent(Event event) {
		return sqlSession.update("admin.updateEvent", event);
	}

	@Override
	public List<Map<String, String>> storePMSList(int cPage, int numPerPage) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("admin.selectStorePMSList", null, rowBounds);
	}

	@Override
	public int countStorePMSList() {
		return sqlSession.selectOne("admin.countStorePMSList");
	}

	@Override
	public List<Map<String, String>> storeList(int cPage, int numPerPage) {
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage,numPerPage);
		return sqlSession.selectList("admin.selectStoreList", null, rowBounds);
	}

	@Override
	public int countStoreList() {
		return sqlSession.selectOne("admin.countStoreList");
	}
	

}
