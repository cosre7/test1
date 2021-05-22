package com.talat.pms.service.impl;

import java.util.List;
import com.talat.pms.dao.DriverQnADao;
import com.talat.pms.domain.DriverQnA;
import com.talat.pms.service.DriverQnAService;

public class DefaultDriverQnAService implements DriverQnAService {

  DriverQnADao driverQnADao; 

  public DefaultDriverQnAService(DriverQnADao driverQnADao) {
    this.driverQnADao = driverQnADao;
  }

  // 게시글 등록 업무
  @Override
  public int add(DriverQnA driverQnA) throws Exception {
    return driverQnADao.insert(driverQnA);
  }

  // 게시글 목록 조회 업무
  @Override
  public List<DriverQnA> list() throws Exception {
    return driverQnADao.findByKeyword(null);
  }

  // 게시글 상세 조회 업무
  @Override
  public DriverQnA get(int no) throws Exception {
    DriverQnA driverQnA = driverQnADao.findByNo(no);
    if (driverQnA != null) {
      driverQnADao.updateViewCount(no);
    }
    return driverQnA; 
  }

  // 게시글 변경 업무
  @Override
  public int update(DriverQnA driverQnA) throws Exception {
    return driverQnADao.update(driverQnA);
  }

  // 게시글 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return driverQnADao.delete(no);
  }

  // 게시글 검색 업무
  @Override
  public List<DriverQnA> search(String keyword) throws Exception {
    return driverQnADao.findByKeyword(keyword);
  }
}







