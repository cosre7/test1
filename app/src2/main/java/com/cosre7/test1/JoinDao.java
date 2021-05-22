package com.cosre7.test1;

import java.util.List;
import com.talat.pms.domain.Join;

public interface JoinDao {

  int insert(Join join) throws Exception;

  List<Join> findAll() throws Exception;

  Join findByNo(int no) throws Exception;

  int update(Join join) throws Exception;

  int delete(int no) throws Exception;

  Join findByNicName(String nicName) throws Exception;
}












