package com.pointedInquery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wyx20
 * @version 1.0
 * @title AddExpertDto
 * @description
 * @create 2023/12/15 20:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddExpertDto {
    private String phone;
    private String realName;
    private String description;
    private String id;
    private String job;
    private Integer type;
}
