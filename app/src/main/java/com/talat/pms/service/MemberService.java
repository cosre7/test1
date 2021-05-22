package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.Member;

public interface MemberService {

  int add1(Member member) throws Exception;

  int add2(Member member) throws Exception;

  List<Member> list() throws Exception;

  Member get(String email, String password) throws Exception;

  Member get(int no) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

}







