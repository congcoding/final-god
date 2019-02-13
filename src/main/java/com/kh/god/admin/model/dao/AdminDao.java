package com.kh.god.admin.model.dao;

import java.util.List;
import java.util.Map;

public interface AdminDao {

	List<Map<String, String>> selectBoardList(int cPage, int numPerPage);

	int countBoardList();

}
