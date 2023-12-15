package com.pointedInquery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Expert对象", description="")
public class Expert implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String phone;

    private String realName;

    private Float rating;

    private String description;

    @ApiModelProperty(value = "身份证号")
    private String id;

    private String job;

//    private Integer price;

    private Integer type;



}
