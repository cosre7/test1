package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.RiderQnA;

// BoardDao 의 규칙 정의
public interface RiderQnADao {

  int insert(RiderQnA riderQnA) throws Exception;

  List<RiderQnA> findAll() throws Exception;

  List<RiderQnA> findByKeyword(String keyword) throws Exception;

  RiderQnA findByNo(int no) throws Exception;

  int update(RiderQnA driverQnA) throws Exception;

  int managerUpdate(RiderQnA driverQnA) throws Exception;

  int delete(int no) throws Exception;
}












