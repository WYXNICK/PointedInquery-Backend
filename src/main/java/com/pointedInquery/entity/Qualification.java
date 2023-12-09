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
@ApiModel(value="Qualification对象", description="")
public class Qualification implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "0心理，1学业，2就业")
    private String qid;

    @TableId
    private String phone;

    private String qname;

    private String content;

    @ApiModelProperty(value = "照片的存储地址")
    private String photo;

    @ApiModelProperty(value = "管理员审核")
    private String state;

}
