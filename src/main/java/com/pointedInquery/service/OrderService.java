package com.pointedInquery.service;

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

    List<Order> GetOrderByID(Object customer_id);

    List<Order> GetOrderByExpertID(Object expert_id);

    boolean CreateOrder(Object customer_id, Object expert_id, Object topic_id, Object appoint_time, Object price);

    boolean DeleteOrder(Object customer_id, Object order_id);

    boolean ModifyOrderStatusToFinish(Object customer_id, Object order_id);

    boolean ModifyOrderStatusToReview(Object customer_id, Object order_id);
}
