package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Order;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Update("update `order` set state=#{newState} where order_id=#{orderId}")
    public boolean updateOrderStatus(String newState,String orderId);
}
