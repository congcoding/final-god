package com.kh.god.admin.model.service;

import java.util.List;
import java.util.Map;

public interface AdminService {

	List<Map<String, String>> selectBoardList(int cPage, int numPerPage);

	int countBoardList();

}
