package com.pointedInquery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private String userId;
    private String expertId;
    private String topicId;
    private String orderId;
    private String text;
    private String time;
    private float score;
    // Getters and Setters
}