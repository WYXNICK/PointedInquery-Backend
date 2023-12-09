package com.pointedInquery.controller;


import com.pointedInquery.entity.Review;
import com.pointedInquery.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/GetReviewByTopicID")
    public List<Review> GetReviewByTopicID(@RequestParam Map<String, Object> param){
        return reviewService.GetReviewByTopicID(param.get("topic_id"));
    }

    @PostMapping("/CreateReview")
    public boolean CreateReview(@RequestParam Map<String, Object> param){
        return reviewService.CreateReview(param.get("user_id"),param.get("expert_id"),param.get("topic_id"),param.get("order_id"),param.get("text"));
    }

    @PostMapping("/DeleteReview")
    public boolean DeleteReview(@RequestParam Map<String, Object> param){
        return reviewService.DeleteReview(param.get("id"));
    }

    @PostMapping("/ModifyReview")
    public boolean ModifyReview(@RequestParam Map<String, Object> param){
        return reviewService.ModifyReview(param.get("id"),param.get("text"));
    }





}
