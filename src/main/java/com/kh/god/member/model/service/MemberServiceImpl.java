package com.kh.god.member.model.service;

import java.util.List;
import java.util.Map;

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


	@Override
	public int deleteMember(String memberId) {
		return memberDao.deleteMember(memberId);
	}


	@Override
	public int checkBookMark(Map<String, String> map) {		
		return memberDao.checkBookMark(map);
	}


	@Override
	public List<Map<String, Object>> couponListBymemberId(String memberId) {
		// TODO Auto-generated method stub
		return memberDao.couponListBymemberId(memberId);
	}


	@Override
	public double getDiscount(String eventNo) {
		// TODO Auto-generated method stub
		return memberDao.getDiscount(eventNo);
	}



}
