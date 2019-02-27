package com.kh.god.member.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.god.member.model.vo.Member;
import com.kh.god.member.model.vo.RAttachment;
import com.kh.god.member.model.vo.Review;
import com.kh.god.seller.model.vo.OrderInfo;
import com.kh.god.seller.model.vo.Seller;
import com.kh.god.storeInfo.model.vo.StoreInfo;

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
		int result = sqlSession.update("member.updateMember",m);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		int result = sqlSession.update("member.deleteMember",memberId);
		return result;
	}

	@Override
	public int checkBookMark(Map<String, String> map) {
		int result = sqlSession.selectOne("member.checkBookMark",map);
		return result;
	}

	@Override
	public List<Map<String, Object>> couponListBymemberId(String memberId) {		
		return sqlSession.selectList("member.couponListBymemberId", memberId);
	}

	public int insertBookMark(Map<String, String> map) {
		int result = sqlSession.insert("member.insertBookMark",map);
		return result;
	}

	@Override
	public int deleteBookMark(Map<String, String> map) {
		int result = sqlSession.delete("member.deleteBookMark",map);
		return result;
	}

	@Override
	public List<StoreInfo> bookMarkList(String memberId) {
		List<StoreInfo> bList = sqlSession.selectList("member.bookMarkList",memberId);
		return bList;
	}

	@Override
	public List<Map<String, String>> orderList(String memberId) {
		List<Map<String, String>> orderList = sqlSession.selectList("member.orderList", memberId);
		return orderList;
	}

	@Override
	public int insertMemberReview(Review review) {
		int result = sqlSession.insert("member.insertMemberReview", review);
		return result;
	}
	
	@Override
	public Review selectOneReview(int orderNo) {
		Review review = sqlSession.selectOne("member.selectOneReview", orderNo);
		return review;
	}

	@Override
	public int insertRAttachment(RAttachment a) {
		int result = sqlSession.insert("member.insertRAttachment", a);
		return result;
	}

	@Override
	public Member findId(String email) {
		Member m = null;
		
		 try{
			m = sqlSession.selectOne("member.findId" , email);
		 }
		 catch(TooManyResultsException e) {
			 
		 }
		 return m;
	}

	@Override
	public Seller sellerfindId(String email) {
		Seller s = null;
		 try{
			s = sqlSession.selectOne("seller.sellerfindId" , email);
		 }
		 catch(TooManyResultsException e) {
			 
		 }
		return s;
	}
	public List<Review> reviewList(String memberId) {
		List<Review> reviewList = sqlSession.selectList("member.reviewList", memberId);
		return reviewList;
	}

	@Override
	public List<RAttachment> selectRAttachmentList(int reviewNo) {
		List<RAttachment> attachmentList = sqlSession.selectList("member.selectRAttachmentList", reviewNo);
		return attachmentList;
	}

	@Override
	public double getDiscount(String eventNo) {
		return sqlSession.selectOne("member.getDiscount", eventNo);
	}

	@Override
	public List<Map<String, String>> selectOrderMenuList(String orderNo) {
		return sqlSession.selectList("member.selectOrderMenuList", orderNo);
	}

	@Override
	public int deleteMemberReview(String reviewNo) {
		return sqlSession.update("member.deleteMemberReview",reviewNo);
	}

}
