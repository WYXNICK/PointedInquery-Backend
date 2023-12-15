package com.pointedInquery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Order对象", description="")
@TableName(value="`order`")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键使用雪花算法生成唯一标识
    @TableId(type = IdType.ASSIGN_ID)
    private String orderId;

    private String customerId;

    private String expertId;

    private String topicId;

    @ApiModelProperty(value = "先支付，才能形成订单")
    private String payTime;

    private String appointTime;

    @ApiModelProperty(value = "进行中，已完成，已评价")
    private String state;

    private Integer price;


}
