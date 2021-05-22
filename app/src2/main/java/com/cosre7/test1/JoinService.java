package com.cosre7.test1;

import java.util.List;
import com.talat.pms.domain.Join;

public interface JoinService {

  int add(Join join) throws Exception;

  List<Join> list() throws Exception;

  Join get(int no) throws Exception;

  int update(Join join) throws Exception;

  int delete(int no) throws Exception;

  Join search(String nicName) throws Exception;
}







