package com.kh.god.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.admin.model.dao.AdminDao;
import com.kh.god.admin.model.vo.Event;
import com.kh.god.admin.model.vo.QnaBoard;
import com.kh.god.seller.model.vo.Seller;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDao adminDao;

	@Override
	public List<Map<String, String>> selectBoardList(int cPage, int numPerPage) {
		return adminDao.selectBoardList(cPage,numPerPage);
	}

	@Override
	public int countBoardList() {
		return adminDao.countBoardList();
	}

	@Override
	public List<Map<String, String>> eventList(int cPage, int numPerPage) {
		return adminDao.selectEventList(cPage,numPerPage);
	}

	@Override
	public int countEventList() {
		return adminDao.countEventList();
	}

	@Override
	public int getLastEventNo() {
		return adminDao.getLastEventNo();
	}

	@Override
	public int insertEvent(Event event) {
		return adminDao.insertEvent(event);
	}

	@Override
	public QnaBoard qnaBoardView(int boardNo) {
		return adminDao.qnaBoardView(boardNo);
	}

	@Override
	public List<Map<String, String>> selectSellerAllList(int cPage, int numPerPage) {
		return adminDao.selectSellerAllList(cPage,numPerPage);
	}

	@Override
	public int countSellerList() {
		return adminDao.countSellerList();
	}

	@Override
	public Event eventView(int eventNo) {
		return adminDao.eventView(eventNo);
	}
	
	public int changeSellerbFlagtoN(String sellerId) {
		return adminDao.changeSellerbFlagtoN(sellerId);
	}

	@Override
	public int changeSellerbFlagtoY(String sellerId) {
		return adminDao.changeSellerbFlagtoY(sellerId);
	}

	@Override
	public int insertAsking(QnaBoard board) {
		return adminDao.insertAsking(board);
	}

	@Override
	public List<Map<String, String>> selectQNAList(int cPage, int numPerPage, String boardWriter) {
		return adminDao.selectQNAList(cPage,numPerPage,boardWriter);
	}

	@Override
	public int countQNAList(String boardWriter) {
		return adminDao.countQNAList(boardWriter);
	}

	@Override
	public List<QnaBoard> boardRefList() {
		return adminDao.boardRefList();
	}

	@Override
	public QnaBoard qnaBoardRefView(int boardNo) {
		return adminDao.qnaBoardRefView(boardNo);
	}

	@Override
	public int countMemberList() {
		return adminDao.countMemberList();
	}

	@Override
	public List<Map<String, String>> selectMemberAllList(int cPage, int numPerPage) {
		return adminDao.selectMemberAllList(cPage,numPerPage);
	}

	@Override
	public int deleteEvent(int eventNo) {
		return adminDao.deleteEvent(eventNo);
	}

}
