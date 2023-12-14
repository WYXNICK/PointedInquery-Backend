package com.pointedInquery.service;

import com.pointedInquery.entity.Review;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface ReviewService extends IService<Review> {

    List<Review> GetReviewByTopicID(Object topic_id);

    boolean CreateReview(Object user_id,Object expert_id, Object topic_id, String order_id, Object text, Object score);

    boolean DeleteReview(Object id);

    boolean ModifyReview(Object id,Object text);

    List<Review> GetReviewByExpertID(String expertId);
}
