package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.DriverQnA;

public interface DriverQnAService {

  int add(DriverQnA driverQnA) throws Exception;

  List<DriverQnA> list() throws Exception;

  DriverQnA get(int no) throws Exception;

  int update(DriverQnA driverQnA) throws Exception;

  int delete(int no) throws Exception;

  List<DriverQnA> search(String keyword) throws Exception;
}







