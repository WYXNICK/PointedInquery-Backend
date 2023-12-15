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
@ApiModel(value="Qualification对象", description="")
public class Qualification implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String phone;

    @ApiModelProperty(value = "管理员审核")
    private String state;

    private String applyTime;

}
