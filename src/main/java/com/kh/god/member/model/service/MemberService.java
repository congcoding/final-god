package com.kh.god.member.model.service;

import com.kh.god.member.model.vo.Member;

public interface MemberService {
	
	int insertMember(Member m);

	Member selectOneMember(String memberId);

	int updateMember(Member m);
	
	
	

}
