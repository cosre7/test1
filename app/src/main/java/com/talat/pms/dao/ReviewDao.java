package com.talat.pms.dao;

import java.util.List;
import com.talat.pms.domain.Review;

public interface ReviewDao {

  int insert(Review review) throws Exception;

  List<Review> findAll() throws Exception;

}












