package com.cosre7.test1;

import java.util.List;
import com.talat.pms.dao.JoinDao;
import com.talat.pms.domain.Join;
import com.talat.pms.service.JoinService;

public class DefaultJoinService implements JoinService {

  JoinDao joinDao;

  public DefaultJoinService(JoinDao joinDao) {
    this.joinDao = joinDao;
  }  

  // 등록 업무
  @Override
  public int add(Join join) throws Exception {
    return joinDao.insert(join);
  }

  // 조회 업무
  @Override
  public List<Join> list() throws Exception {
    return joinDao.findAll();
  }

  // 상세 조회 업무
  @Override
  public Join get(int no) throws Exception {
    return joinDao.findByNo(no);
  }

  // 변경 업무
  @Override
  public int update(Join join) throws Exception {
    return joinDao.update(join);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return joinDao.delete(no);
  }

  // 닉네임으로 찾기
  @Override
  public Join search(String nicName) throws Exception {
    return joinDao.findByNicName(nicName);
  }
}







