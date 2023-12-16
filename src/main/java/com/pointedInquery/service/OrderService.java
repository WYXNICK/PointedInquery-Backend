package com.pointedInquery.service;

import com.pointedInquery.dto.OrderDetailedInfoDto;
import com.pointedInquery.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface OrderService extends IService<Order> {

    List<OrderDetailedInfoDto> GetOrderByID(Object customer_id);

    List<OrderDetailedInfoDto> GetOrderByExpertID(Object expert_id);

    boolean CreateOrder(String customer_id, String expert_id, String topic_id, String appoint_time, Integer price);

    boolean DeleteOrder(Object customer_id, Object order_id);

    boolean ModifyOrderStatusToFinish(Object customer_id, Object order_id);

    boolean ModifyOrderStatusToReview(Object customer_id, Object order_id);

    int CancleOrder(String orderId);
}
