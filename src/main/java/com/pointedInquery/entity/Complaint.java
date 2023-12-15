package com.pointedInquery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="Complaint对象", description="")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer complaintId;

    @TableField("order_id")
    private String orderId;

    @TableField("user_id")
    private String userId;

    @TableField("be_user_id")
    private String beUserId;

    @ApiModelProperty(value = "未处理，投诉通过，驳回")
    @TableField("state")
    private String state;

    @TableField("time")
    private String time;

    @TableField("contents")
    private String contents;

}
