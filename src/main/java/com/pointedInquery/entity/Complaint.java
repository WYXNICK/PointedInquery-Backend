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
@ApiModel(value="Complaint对象", description="")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String orderId;

    private String userId;

    private String beUserId;

    @ApiModelProperty(value = "未处理，投诉通过，驳回")
    private String state;

    private String time;

    private String contents;



    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public void setBeUserId(String beUserId) {
        this.beUserId = beUserId;
    }


    public void setState(String state) {
        this.state = state;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public void setContents(String contents) {
        this.contents = contents;
    }
}
