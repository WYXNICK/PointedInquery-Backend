package com.pointedInquery.controller;


import com.pointedInquery.dto.ReviewDTO;
import com.pointedInquery.entity.Review;
import com.pointedInquery.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/GetReviewByTopicID")
    public List<Review> GetReviewByTopicID(@RequestParam String topic_id){
        return reviewService.GetReviewByTopicID(topic_id);
    }

    @GetMapping("/GetReviewByExpertID")
    public List<Review> GetReviewByExpertID(@RequestParam String expert_id){
        return  reviewService.GetReviewByExpertID(expert_id);
    }

//    @PostMapping("/CreateReview")
//    public boolean CreateReview(@RequestParam Map<String, Object> param){
//        return reviewService.CreateReview(param.get("user_id"),param.get("expert_id"),param.get("topic_id"),param.get("order_id"),param.get("text"));
//    }

    @PostMapping("/CreateReview")
    public boolean CreateReview(@RequestBody ReviewDTO reviewDTO){
        return reviewService.CreateReview(reviewDTO.getUserId(), reviewDTO.getExpertId(), reviewDTO.getTopicId(), reviewDTO.getText(), reviewDTO.getOrderId(), reviewDTO.getScore());
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
