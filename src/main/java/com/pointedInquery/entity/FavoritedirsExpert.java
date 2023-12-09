package com.pointedInquery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * VIEW
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="FavoritedirsExpert对象", description="VIEW")
public class FavoritedirsExpert implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String customerId;

    private String expertId;

    private String realName;

    @ApiModelProperty(value = "职位")
    private String job;

    private Float rating;

    private String title;

    @ApiModelProperty(value = "每小时价格")
    private Integer price;

    private Integer addrProvince;


}
