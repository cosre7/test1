package com.talat.pms.dao;

import java.util.List;
import java.util.Map;
import com.talat.pms.domain.Member;

public interface MemberDao2 {

  int insert(Member member) throws Exception;

  List<Member> findAll() throws Exception;

  Member findByNo(int no) throws Exception;

  Member findByEmailPassword(Map<String,Object> params) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

  Member findByName(String name) throws Exception;
}












