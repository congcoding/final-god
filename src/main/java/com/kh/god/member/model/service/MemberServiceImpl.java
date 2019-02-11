package com.kh.god.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.member.model.dao.MemberDao;
import com.kh.god.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
		
	
	@Override
	public int insertMember(Member m) {
		return memberDao.insertMember(m);
	}


	@Override
	public Member selectOneMember(String memberId) {
		return memberDao.selectOneMember(memberId);
	}


	@Override
	public int updateMember(Member m) {
		return memberDao.updateMember(m);
	}

}
