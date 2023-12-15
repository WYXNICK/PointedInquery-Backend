package com.pointedInquery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Topic对象", description="")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String topicId;

    private String expertId;

    private String title;

    private String text;

    @ApiModelProperty(value = "每小时价格")
    private Integer price;

    @ApiModelProperty(value = "线上，线下，皆可")
    private String way;

    @ApiModelProperty(value = "话题发布时间")
    private String topicTime;


    @ApiModelProperty(value = "管理员审核")
    private String state;
}
