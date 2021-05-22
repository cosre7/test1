package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.Route;

public interface JourneyService {

  int add(Journey journey) throws Exception;

  List<Journey> list() throws Exception;

  Journey get(int no) throws Exception;

  int update(Journey journey) throws Exception;

  int delete(int no) throws Exception;

  //  List<Journey> search(String departure, String arrival) throws Exception;

  List<Route> getRoutes(int journeyNo) throws Exception;

  int deleteRoutes (int journeyNo) throws Exception;

  int updateRoutes(int journeyNo, List<Route> routes) throws Exception;

}







