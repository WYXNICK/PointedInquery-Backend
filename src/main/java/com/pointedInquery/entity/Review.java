package com.pointedInquery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="Review对象", description="")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userId;

    private String expertId;

    private String topicId;

    private String text;

    private String time;

    private String orderId;

    private float score;
}
