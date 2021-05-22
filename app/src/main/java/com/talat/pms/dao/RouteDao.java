package com.talat.pms.dao;

import java.math.BigDecimal;
import java.util.List;
import com.talat.pms.domain.Route;

// JourneyDao 의 규칙 정의
public interface RouteDao {

  int insert(Route route) throws Exception;

  List<Route> findAll() throws Exception;

  List<Route> findByKeyword(BigDecimal latitude, BigDecimal longitude) throws Exception;

  Route findByNo(int no) throws Exception;

  int update(Route route) throws Exception;

  int delete(int no) throws Exception;

  int deleteByJourneyNo(int journeyNo) throws Exception;
}












