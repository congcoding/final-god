package com.kh.god.admin.model.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.admin.model.dao.AdminDao;
import com.kh.god.admin.model.vo.Ad;
import com.kh.god.admin.model.vo.Coupon;
import com.kh.god.admin.model.vo.Event;
import com.kh.god.admin.model.vo.QnaBoard;
import com.kh.god.seller.model.vo.OrderInfo;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.SAttachment;
import com.kh.god.storeInfo.model.vo.StoreInfo;

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
	public List<Map<String, String>> eventAllList(int cPage, int numPerPage) {
		return adminDao.selectEventAllList(cPage,numPerPage);
	}

	@Override
	public int countEventAllList() {
		return adminDao.countEventAllList();
	}
	
	@Override
	public List<Map<String, String>> eventIngList(int cPage, int numPerPage) {
		return adminDao.selectEventIngList(cPage,numPerPage);
	}

	@Override
	public int countEventIngList() {
		return adminDao.countEventIngList();
	}
	
	@Override
	public List<Map<String, String>> eventEndList(int cPage, int numPerPage) {
		return adminDao.selectEventEndList(cPage,numPerPage);
	}

	@Override
	public int countEventEndList() {
		return adminDao.countEventEndList();
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

	@Override
	public List<Map<String, String>> qnaControlList(int cPage, int numPerPage) {
		return adminDao.qnaControlList(cPage,numPerPage);
	}

	@Override
	public int countQnaControlList() {
		return adminDao.countQnaControlList();
	}

	@Override
	public QnaBoard qnaAnswer(int boardNo) {
		return adminDao.qnaAnswer(boardNo);
	}

	@Override
	public int insertAnswer(QnaBoard answer) {
		return adminDao.insertAnswer(answer);
	}

	@Override
	public List<Map<String, String>> selectSellerBL(int cPage, int numPerPage) {
		return adminDao.selectSellerBL(cPage,numPerPage);
	}

	@Override
	public int countSellerBL() {
		return adminDao.countSellerBL();
	}

	@Override
	public int countMemberBL() {
		return adminDao.countMemberBL();
	}

	@Override
	public List<Map<String, String>> selectMemberBL(int cPage, int numPerPage) {
		return adminDao.selectMemberBL(cPage,numPerPage);
	}

	@Override
	public int changeMemberbFlagtoN(String memberId) {
		return adminDao.changeMemberbFlagtoN(memberId);
	}

	@Override
	public int changeMemberbFlagtoY(String memberId) {
		return adminDao.changeMemberbFlagtoY(memberId);
	}

	@Override
	public List<Map<String, String>> selectAdList(int cPage, int numPerPage) {
		return adminDao.selectAdList(cPage,numPerPage);
	}

	@Override
	public int countAdList() {
		return adminDao.countAdList();
	}
	
	@Override
	public List<Map<String, String>> selectAdingList(int cPage, int numPerPage) {
		return adminDao.selectAdingList(cPage,numPerPage);
	}

	@Override
	public int countAdingList() {
		return adminDao.countAdingList();
	}
	
	@Override
	public List<Map<String, String>> selectAdedList(int cPage, int numPerPage) {
		return adminDao.selectAdedList(cPage,numPerPage);
	}

	@Override
	public int countAdedList() {
		return adminDao.countAdedList();
	}

	@Override
	public StoreInfo adStoreView(String storeNo) {
		return adminDao.adStoreView(storeNo);
	}

	@Override
	public Ad adStoreAdView(int adNo) {
		return adminDao.adStoreAdView(adNo);
	}

	@Override
	public int deleteAd(Map<String, String> map) {
		return adminDao.deleteAd(map);
	}
		
	public int updateEvent(Event event) {
		return adminDao.updateEvent(event);
	}

	@Override
	public List<Map<String, String>> storePMSList(int cPage, int numPerPage) {
		return adminDao.storePMSList(cPage, numPerPage);
	}

	@Override
	public int countStorePMSList() {
		return adminDao.countStorePMSList();
	}

	@Override
	public List<Map<String, String>> storeList(int cPage, int numPerPage) {
		return adminDao.storeList(cPage, numPerPage);
	}

	@Override
	public int countStoreList() {
		return adminDao.countStoreList();
	}
	
	@Override
	public int couponDownload(Coupon coupon) {
		return adminDao.couponDownload(coupon);
	}
	
	@Override
	public List<OrderInfo> timeChart() {
		return adminDao.timeChart();
	}

//	---------------------------------------------------------
	
	@Override
	public StoreInfo storePMSView(String storeNo) {
		return adminDao.storePMSView(storeNo);
	}

	@Override
	public List<Map<String, String>> storePMSAttaView(String storeNo) {
		return adminDao.storePMSAttaView(storeNo);
	}

	@Override
	public int storePMSOk(String storeNo) {
		return adminDao.storePMSOk(storeNo);
	}
	
	@Override
	public int storePMSReject(Map<String, String> map) {
		return adminDao.storeReject(map);
	}

	@Override
	public int storePMSClose(String storeNo) {
		return adminDao.storePMSClose(storeNo);
	}

	@Override
	public int storePMSOpen(String storeNo) {
		return adminDao.storePMSOpen(storeNo);
	}

	@Override
	public List<Event> carouselEvent() {
		return adminDao.carouselEvent();
	}

}
