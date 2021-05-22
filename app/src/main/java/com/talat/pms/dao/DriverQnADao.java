package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.DriverQnA;

// BoardDao 의 규칙 정의
public interface DriverQnADao {

  int insert(DriverQnA driverQnA) throws Exception;

  List<DriverQnA> findByKeyword(String keyword) throws Exception;

  DriverQnA findByNo(int no) throws Exception;

  int update(DriverQnA driverQnA) throws Exception;

  int updateViewCount(int no) throws Exception;

  int delete(int no) throws Exception;
}












