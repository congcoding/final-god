package com.kh.god.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int insertMember(Member m) {
		int result = sqlSession.insert("member.insertMember",m);
		return result;
	}

	@Override
	public Member selectOneMember(String memberId) {
		Member m = sqlSession.selectOne("member.selectOneMember",memberId); 
		return m;
	}

	@Override
	public int updateMember(Member m) {
		System.out.println(m);
		int result = sqlSession.update("member.updateMember",m);
		return result;
	}

}