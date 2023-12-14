package com.pointedInquery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wyx20
 * @version 1.0
 * @title ComplaintCreateDto
 * @description
 * @create 2023/12/14 20:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintCreateDto {
    private String orderId;
    private String userId;
    private String beUserId;
    private String contents;
}
