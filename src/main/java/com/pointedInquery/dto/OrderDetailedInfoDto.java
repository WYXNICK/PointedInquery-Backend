package com.pointedInquery.dto;

import com.pointedInquery.entity.Topic;
import com.pointedInquery.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wyx20
 * @version 1.0
 * @title OrderDetailedInfo
 * @description
 * @create 2023/12/13 8:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailedInfoDto {
    private String orderId;

//    private String customerId;

    private String expertId;

    private User user;

    private Topic topic;

    private String payTime;

    private String appointTime;

    private String state;

    private Integer price;
    //专家名称
    private String realName;
    //主题标题
    private String title;
}
