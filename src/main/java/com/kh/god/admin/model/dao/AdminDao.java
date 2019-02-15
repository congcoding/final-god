package com.kh.god.admin.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.god.admin.model.vo.Event;
import com.kh.god.admin.model.vo.QnaBoard;

public interface AdminDao {

	List<Map<String, String>> selectBoardList(int cPage, int numPerPage);

	int countBoardList();

	List<Map<String, String>> selectEventList(int cPage, int numPerPage);

	int countEventList();

	int getLastEventNo();

	int insertEvent(Event event);

	QnaBoard qnaBoardView(int boardNo);

}
