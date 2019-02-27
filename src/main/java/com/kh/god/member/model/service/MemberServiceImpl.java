package com.kh.god.member.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.god.member.model.dao.MemberDao;
import com.kh.god.member.model.vo.Member;
import com.kh.god.member.model.vo.RAttachment;
import com.kh.god.member.model.vo.Review;
import com.kh.god.seller.model.vo.OrderInfo;
import com.kh.god.storeInfo.model.vo.StoreInfo;

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

	public int insertBookMark(Map<String, String> map) {
		return memberDao.insertBookMark(map);
	}


	@Override
	public double getDiscount(String eventNo) {
		// TODO Auto-generated method stub
		return memberDao.getDiscount(eventNo);
	}
	
	public int deleteBookMark(Map<String, String> map) {
		return memberDao.deleteBookMark(map);
	}


	@Override
	public List<StoreInfo> bookMarkList(String memberId) {
		return memberDao.bookMarkList(memberId);
	}


	@Override
	public List<Map<String, String>> orderList(String memberId) {
		return memberDao.orderList(memberId);
	}


	@Override
	public int insertMemberReview(Review review) {	
		return memberDao.insertMemberReview(review);
	}

	
	@Override
	public Review selectOneReview(int orderNo) {
		return memberDao.selectOneReview(orderNo);
	}


	@Override
	public int insertRAttachment(RAttachment a) {
		return memberDao.insertRAttachment(a);
	}


	@Override
	public List<Review> reviewList(String memberId) {
		return memberDao.reviewList(memberId);
	}


	@Override
	public List<RAttachment> selectRAttachmentList(int reviewNo) {
		return memberDao.selectRAttachmentList(reviewNo);
	}



}
