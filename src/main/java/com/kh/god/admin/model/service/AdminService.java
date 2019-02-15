package com.kh.god.admin.model.service;

import java.util.List;
import java.util.Map;

import com.kh.god.admin.model.vo.Event;
import com.kh.god.admin.model.vo.QnaBoard;
import com.kh.god.seller.model.vo.Seller;

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

	int changeSellerbFlagtoN(String sellerId);

	int changeSellerbFlagtoY(String sellerId);

	List<Map<String, String>> selectMemberQNAList(int cPage, int numPerPage, String memberId);

	int countMemberQNAList(String memberId);

	List<Map<String, String>> selectSellerQNAList(int cPage, int numPerPage, String sellerId);

	int countSellerQNAList(String sellerId);

}
