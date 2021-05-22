package com.talat.pms.service.impl;

import java.util.List;
import com.talat.pms.dao.ReviewDao;
import com.talat.pms.domain.Review;
import com.talat.pms.service.ReviewService;

public class DefaultReviewService implements ReviewService {

  ReviewDao reviewDao;

  public DefaultReviewService(ReviewDao reviewDao) {
    this.reviewDao = reviewDao;
  }  

  // 등록 업무
  @Override
  public int add(Review review) throws Exception {
    return reviewDao.insert(review);
  }

  // 조회 업무
  @Override
  public List<Review> list() throws Exception {
    return reviewDao.findAll();
  }
}







