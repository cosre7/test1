package com.talat.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import com.talat.mybatis.TransactionCallback;
import com.talat.mybatis.TransactionManager;
import com.talat.mybatis.TransactionTemplate;
import com.talat.pms.dao.JourneyRiderDao;
import com.talat.pms.domain.Journey;
import com.talat.pms.domain.JourneyRider;
import com.talat.pms.service.JourneyRiderService;

public class DefaultJourneyRiderService implements JourneyRiderService {

  TransactionTemplate transactionTemplate;
  JourneyRiderDao journeyRiderDao; 

  public DefaultJourneyRiderService(TransactionManager txManager, JourneyRiderDao journeyRiderDao) {
    this.transactionTemplate = new TransactionTemplate(txManager);
    this.journeyRiderDao = journeyRiderDao;
  }

  // 등록 업무
  @Override
  public int add(JourneyRider journeyRider) throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("journeyNo", journeyRider.getJourneyRiderNo());
    params.put("journeys", journeyRider.getJourneys());
    return journeyRiderDao.insertJourney(params);
  }

  // 목록 조회 업무
  @Override
  public List<JourneyRider> list() throws Exception {
    return journeyRiderDao.findAll();
  }

  // 상세 조회 업무
  @Override
  public JourneyRider get(int no) throws Exception {
    return journeyRiderDao.findByNo(no); 
  }


  // 변경 업무
  @Override
  public int update(JourneyRider journeyRider) throws Exception {
    return journeyRiderDao.update(journeyRider);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return (int) transactionTemplate.execute(new TransactionCallback() {
      @Override
      public Object doInTransaction() throws Exception {
        journeyRiderDao.deleteJourney(no);
        return journeyRiderDao.delete(no);
      }
    });
  }

  // 검색 업무
  @Override
  public List<JourneyRider> search(String keyword1, String keyword2, String keyword3, String keyword4) throws Exception {
    HashMap<String, Object> params = new HashMap<>();
    params.put("keyword1", keyword1);
    params.put("keyword2", keyword2);
    params.put("keyword3", keyword3);
    params.put("keyword4", keyword4);

    return journeyRiderDao.findByKeyword(params);
  }

  @Override
  public List<Journey> getJourney(int journeyRiderNo) throws Exception {
    return journeyRiderDao.findJourneys(journeyRiderNo);
  }

  @Override
  public int deleteJourney(int journeyRiderNo) throws Exception {
    return journeyRiderDao.deleteJourney(journeyRiderNo);
  }

}







