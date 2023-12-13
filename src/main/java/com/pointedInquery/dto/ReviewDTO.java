package com.pointedInquery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private String user_id;
    private String expert_id;
    private String topic_id;
    private String order_id;
    private String text;
    private float score;
    // Getters and Setters
}