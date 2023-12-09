package com.pointedInquery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Onlinetalk对象", description="")
public class Onlinetalk implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String messageId;


    @ApiModelProperty(value = "发送方phone")
    private String sendFrom;


    @ApiModelProperty(value = "接收方phone")
    private String sendTo;

    private String content;

    private String createAt;

    @ApiModelProperty(value = "第几次发送消息")
    private Integer number;


}
