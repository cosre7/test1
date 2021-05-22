package com.talat.pms.dao;

import java.util.List;
import java.util.Map;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.Route;

// JourneyDao 의 규칙 정의
public interface JourneyDao {

  int insert(Journey journey) throws Exception;

  List<Journey> findAll() throws Exception;

  //  List<Journey> findByKeyword(String departure, String arrival) throws Exception;

  Journey findByNo(int no) throws Exception;

  int update(Journey journey) throws Exception;

  int delete(int no) throws Exception;

  //  List<Route> search(String departure, String arrival) throws Exception;

  List<Route> findRoutes(int journeyNo) throws Exception;

  int insertRoutes(Map<String,Object> params) throws Exception;

  int deleteRoutes (int journeyNo) throws Exception;
}












