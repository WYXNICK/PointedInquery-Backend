package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Order;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
