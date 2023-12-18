package com.pointedInquery.controller;


import com.pointedInquery.dto.ReviewDto;
import com.pointedInquery.entity.Review;
import com.pointedInquery.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/GetReviewByExpertID")
    public List<Review> GetReviewByExpertID(@RequestParam String expertId){
        return  reviewService.GetReviewByExpertID(expertId);
    }

    @PostMapping("/CreateReview")
    public boolean CreateReview(ReviewDto reviewDto){
        return reviewService.CreateReview(reviewDto.getUserId(), reviewDto.getExpertId(), reviewDto.getTopicId(), reviewDto.getOrderId(), reviewDto.getText(), reviewDto.getScore());
    }

}
