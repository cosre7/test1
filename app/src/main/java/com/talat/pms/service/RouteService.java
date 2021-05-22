package com.talat.pms.service;

import java.math.BigDecimal;
import java.util.List;
import com.talat.pms.domain.Route;

public interface RouteService {

  int add(Route route) throws Exception;
  //
  List<Route> list() throws Exception;

  Route get(int no) throws Exception;

  int update(Route route) throws Exception;

  int delete(int no) throws Exception;

  List<Route> search(BigDecimal latitude, BigDecimal longitude) throws Exception;
}







