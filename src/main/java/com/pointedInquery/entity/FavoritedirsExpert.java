package com.pointedInquery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * VIEW
 * </p>
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="FavoritedirsExpert对象", description="")
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


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAddrProvince() {
        return addrProvince;
    }

    public void setAddrProvince(Integer addrProvince) {
        this.addrProvince = addrProvince;
    }
}
