package com.talat.pms.service.impl;

import java.util.List;
import com.talat.pms.dao.RiderQnADao;
import com.talat.pms.domain.RiderQnA;
import com.talat.pms.service.RiderQnAService;

public class DefaultRiderQnAService implements RiderQnAService {

  RiderQnADao riderQnADao; 

  public DefaultRiderQnAService(RiderQnADao riderQnADao) {
    this.riderQnADao = riderQnADao;
  }

  // 게시글 등록 업무
  @Override
  public int add(RiderQnA riderQnA) throws Exception {
    return riderQnADao.insert(riderQnA);
  }

  // 게시글 목록 조회 업무
  @Override
  public List<RiderQnA> list() throws Exception {
    return riderQnADao.findAll();
  }

  // 게시글 상세 조회 업무
  @Override
  public RiderQnA get(int no) throws Exception {
    RiderQnA riderQnA = riderQnADao.findByNo(no);
    return riderQnA; 
  }

  // 게시글 변경 업무
  @Override
  public int update(RiderQnA riderQnA) throws Exception {
    return riderQnADao.update(riderQnA);
  }

  // 답변 업데이트
  @Override
  public int managerUpdate(RiderQnA riderQnA) throws Exception {
    return riderQnADao.managerUpdate(riderQnA);
  }

  // 게시글 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return riderQnADao.delete(no);
  }

  // 게시글 검색 업무
  @Override
  public List<RiderQnA> search(String keyword) throws Exception {
    return riderQnADao.findByKeyword(keyword);
  }
}







