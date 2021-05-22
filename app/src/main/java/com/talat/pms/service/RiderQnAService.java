package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.RiderQnA;

public interface RiderQnAService {

  int add(RiderQnA driverQnA) throws Exception;

  List<RiderQnA> list() throws Exception;

  RiderQnA get(int no) throws Exception;

  int update(RiderQnA riderQnA) throws Exception;

  int managerUpdate(RiderQnA riderQnA) throws Exception;

  int delete(int no) throws Exception;

  List<RiderQnA> search(String keyword) throws Exception;
}







