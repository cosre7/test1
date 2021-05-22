package com.talat.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import com.talat.mybatis.TransactionCallback;
import com.talat.mybatis.TransactionManager;
import com.talat.mybatis.TransactionTemplate;
import com.talat.pms.dao.JourneyDao;
import com.talat.pms.dao.RouteDao;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.Route;
import com.talat.pms.service.JourneyService;

public class DefaultJourneyService implements JourneyService {

  TransactionTemplate transactionTemplate;

  JourneyDao journeyDao; 
  RouteDao routeDao;

  public DefaultJourneyService(TransactionManager txManager, JourneyDao journeyDao, RouteDao routeDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.journeyDao = journeyDao;
    this.routeDao = routeDao;
  }

  // 등록 업무
  @Override
  public int add(Journey journey) throws Exception {
    return (int) transactionTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction() throws Exception {
        int count = journeyDao.insert(journey); 

        if (journey.getRoutes().size() > 0) {
          HashMap<String,Object> params = new HashMap<>();
          params.put("jno", journey.getJno());
          params.put("routes", journey.getRoutes());

          journeyDao.insertRoutes(params);
        }

        return count;
      }
    });
  }

  // 목록 조회 업무
  @Override
  public List<Journey> list() throws Exception {
    return journeyDao.findAll();
  }

  // 상세 조회 업무
  @Override
  public Journey get(int no) throws Exception {
    return journeyDao.findByNo(no);
  }

  @Override
  public List<Route> getRoutes(int journeyNo) throws Exception {
    return journeyDao.findRoutes(journeyNo);
  }

  // 변경 업무
  @Override
  public int update(Journey journey) throws Exception {
    return (int) transactionTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction() throws Exception {
        int count = journeyDao.update(journey);
        journeyDao.deleteRoutes(journey.getJno());

        if (journey.getRoutes().size() > 0) {
          HashMap<String,Object> params = new HashMap<>();
          params.put("projectNo", journey.getJno());
          params.put("members", journey.getRoutes());

          journeyDao.insertRoutes(params);
        }

        return count;
      }
    });
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return (int) transactionTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction() throws Exception {
        routeDao.deleteByJourneyNo(no);
        journeyDao.deleteRoutes(no);
        return  journeyDao.delete(no);
      }
    });
  }

  @Override
  public int deleteRoutes(int journeyNo) throws Exception {
    return journeyDao.deleteRoutes(journeyNo);
  }

  @Override
  public int updateRoutes(int journeyNo, List<Route> routes) throws Exception {
    return (int) transactionTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction() throws Exception {
        journeyDao.deleteRoutes(journeyNo);

        HashMap<String,Object> params = new HashMap<>();
        params.put("journeyNo", journeyNo);
        params.put("routes", routes);

        return journeyDao.insertRoutes(params);
      }
    });
  }

  // 검색 업무
  //  @Override
  //  public List<Journey> search(String departure, String arrival, Date journeyDate, Time journeyTime) throws Exception {
  //    return journeyDao.findByKeyword(departure, arrival, journeyDate, journeyTime);
  //  }
  //
  //  public List<Journey> search(String departure, String arrival) throws Exception {
  //    HashMap<String,Object> params = new HashMap<>();
  //    params.put("departure", departure);
  //    params.put("arrival", arrival);
  //
  //    return journeyDao.findByRoutes(params);
  //  }


}







