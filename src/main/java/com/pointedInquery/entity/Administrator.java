package com.pointedInquery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="Administrator对象", description="")
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String phone;

    private String name;

    private String password;


}
