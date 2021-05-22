package com.talat.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.talat.pms.dao.MemberDao2;
import com.talat.pms.domain.Member;
import com.talat.pms.service.MemberService2;

public class DefaultMemberService2 implements MemberService2 {

  MemberDao2 memberDao2;

  public DefaultMemberService2(MemberDao2 memberDao2) {
    this.memberDao2 = memberDao2;
  }  

  // 등록 업무
  @Override
  public int add(Member member) throws Exception {
    return memberDao2.insert(member);
  }

  // 조회 업무
  @Override
  public List<Member> list() throws Exception {
    return memberDao2.findAll();
  }

  // 사용자 조회 업무
  @Override
  public Member get(String email, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("email", email);
    params.put("password", password);

    return memberDao2.findByEmailPassword(params);
  }

  // 변경 업무
  @Override
  public int update(Member member) throws Exception {
    return memberDao2.update(member);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return memberDao2.delete(no);
  }

}







