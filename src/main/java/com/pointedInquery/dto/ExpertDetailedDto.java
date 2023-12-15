package com.pointedInquery.dto;

import com.pointedInquery.entity.Review;
import com.pointedInquery.entity.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

/**
 * @author wyx20
 * @version 1.0
 * @title ExpertDetailedDto
 * @description
 * @create 2023/12/13 8:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpertDetailedDto {
    private String expertId;
    private String realName;
    private Float rating;
    private String description;
    private String id;
    private String job;
    private Integer price;
    private Integer type;
    private List<Topic> topics;
    private List<HashMap<String,Object>> reviews;
}
