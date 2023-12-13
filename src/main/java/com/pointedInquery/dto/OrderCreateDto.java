package com.pointedInquery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wyx20
 * @version 1.0
 * @title OrderCreateDto
 * @description
 * @create 2023/12/13 14:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto {
    String customer_id;
    String expert_id;
    String topic_id;
    String appoint_time;
    Integer price;
}
