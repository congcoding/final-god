package com.kh.god.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kh.god.member.model.vo.Member;
import com.kh.god.member.model.vo.RAttachment;
import com.kh.god.member.model.vo.Review;
import com.kh.god.seller.model.vo.OrderInfo;
import com.kh.god.storeInfo.model.vo.StoreInfo;

public interface MemberDao {

	int insertMember(Member m);

	Member selectOneMember(String memberId);

	int updateMember(Member m);

	int deleteMember(String memberId);

	int checkBookMark(Map<String, String> map);

	int insertBookMark(Map<String, String> map);

	int deleteBookMark(Map<String, String> map);

	List<StoreInfo> bookMarkList(String memberId);

	List<Map<String, String>> orderList(String memberId);

	int insertMemberReview(Review review);

	Review selectOneReview(int orderNo);

	int insertRAttachment(RAttachment a);


}
