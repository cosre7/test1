package com.talat.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.talat.pms.dao.MemberDao;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService;

public class DefaultMemberService implements MemberService {

  MemberDao memberDao;

  public DefaultMemberService(MemberDao memberDao) {
    this.memberDao = memberDao;
  }  

  // 등록 업무
  @Override
  public int add1(Member member) throws Exception {
    return memberDao.insert1(member);
  }

  @Override
  public int add2(Member member) throws Exception {
    return memberDao.insert2(member);
  }

  // 조회 업무
  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }

  // 사용자 조회 업무
  @Override
  public Member get(String email, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);

    return memberDao.findByEmailPassword(params);
  }

  //사용자 조회 업무
  @Override
  public Member get(int no) throws Exception {
    Member member = memberDao.findByNo(no);

    return member;
  }

  // 변경 업무
  @Override
  public int update(Member member) throws Exception {
    return memberDao.update(member);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return memberDao.delete(no);
  }

}







