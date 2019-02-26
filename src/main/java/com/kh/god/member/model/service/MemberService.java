package com.kh.god.member.model.service;

import java.util.List;
import java.util.Map;

import com.kh.god.member.model.vo.Member;

public interface MemberService {
	
	int insertMember(Member m);

	Member selectOneMember(String memberId);

	int updateMember(Member m);

	int deleteMember(String memberId);

	int checkBookMark(Map<String, String> map);

	List<Map<String, Object>> couponListBymemberId(String memberId);

	double getDiscount(String eventNo);


	
	
	

}
