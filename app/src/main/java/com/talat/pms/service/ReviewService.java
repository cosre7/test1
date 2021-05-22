package com.talat.pms.service;

import java.util.List;
import com.talat.pms.domain.Review;

public interface ReviewService {

  int add(Review review) throws Exception;

  List<Review> list() throws Exception;
}







