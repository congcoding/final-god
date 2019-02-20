package com.kh.god.admin.model.service;

import java.util.List;
import java.util.Map;

import com.kh.god.admin.model.vo.Ad;
import com.kh.god.admin.model.vo.Event;
import com.kh.god.admin.model.vo.QnaBoard;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface AdminService {

	List<Map<String, String>> selectBoardList(int cPage, int numPerPage);

	int countBoardList();

	List<Map<String, String>> eventList(int cPage, int numPerPage);

	int countEventList();

	int getLastEventNo();

	int insertEvent(Event event);

	QnaBoard qnaBoardView(int boardNo);

	List<Map<String, String>> selectSellerAllList(int cPage, int numPerPage);

	int countSellerList();

	Event eventView(int eventNo);
	
	int changeSellerbFlagtoN(String sellerId);

	int changeSellerbFlagtoY(String sellerId);
	

	int insertAsking(QnaBoard board);

	List<Map<String, String>> selectQNAList(int cPage, int numPerPage, String boardWriter);

	int countQNAList(String boardWriter);

	List<QnaBoard> boardRefList();

	QnaBoard qnaBoardRefView(int boardNo);

	int countMemberList();

	List<Map<String, String>> selectMemberAllList(int cPage, int numPerPage);

	int deleteEvent(int eventNo);

	List<Map<String, String>> qnaControlList(int cPage, int numPerPage);

	int countQnaControlList();

	QnaBoard qnaAnswer(int boardNo);

	int insertAnswer(QnaBoard answer);

	List<Map<String, String>> selectSellerBL(int cPage, int numPerPage);

	int countSellerBL();

	int countMemberBL();

	List<Map<String, String>> selectMemberBL(int cPage, int numPerPage);

	int changeMemberbFlagtoN(String memberId);

	int changeMemberbFlagtoY(String memberId);

	List<Map<String, String>> selectAdList(int cPage, int numPerPage);

	int countAdList();
	
	List<Map<String, String>> selectAdingList(int cPage, int numPerPage);

	int countAdingList();
	
	List<Map<String, String>> selectAdedList(int cPage, int numPerPage);

	int countAdedList();

	StoreInfo adStoreView(String storeNo);

	Ad adStoreAdView(int adNo);

	int deleteAd(Map<String, String> map);

}
