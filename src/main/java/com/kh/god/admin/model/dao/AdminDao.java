package com.kh.god.admin.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.god.admin.model.vo.Event;
import com.kh.god.admin.model.vo.QnaBoard;
import com.kh.god.seller.model.vo.Seller;

public interface AdminDao {

	List<Map<String, String>> selectBoardList(int cPage, int numPerPage);

	int countBoardList();

	List<Map<String, String>> selectEventList(int cPage, int numPerPage);

	int countEventList();

	int getLastEventNo();

	int insertEvent(Event event);

	QnaBoard qnaBoardView(int boardNo);

	List<Map<String, String>> selectSellerAllList(int cPage, int numPerPage);

	int countSellerList();

	Event eventView(int eventNo);
	
	int changeSellerbFlagtoN(String sellerId);

	int changeSellerbFlagtoY(String sellerId);

	List<Map<String, String>> selectMemberQNAList(int cPage, int numPerPage, String memberId);

	int countMemberQNAList(String memberId);

	List<Map<String, String>> selectSellerQNAList(int cPage, int numPerPage, String sellerId);

	int countSellrQNAList(String sellerId);

	int deleteEvent(int eventNo);

}
