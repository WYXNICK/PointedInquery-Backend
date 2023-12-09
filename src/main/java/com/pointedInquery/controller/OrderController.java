package com.pointedInquery.controller;



import com.pointedInquery.entity.Order;
import com.pointedInquery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*
    我的订单
    */
    @PostMapping("/GetOrderByID")
    public List<Order> GetOrderByID(@RequestParam Map<String, Object> param) {
        return orderService.GetOrderByID(param.get("customer_id"));
    }
    @PostMapping("/GetOrderByExpertID")
    public List<Order> GetOrderByExpertID(@RequestParam Map<String, Object> param) {
        return orderService.GetOrderByExpertID(param.get("expert_id"));
    }

    @PostMapping("/CreateOrder")
    public boolean CreateOrder(@RequestParam Map<String, Object> param) {
        System.out.println(param.get("customer_id"));
        System.out.println(param.get("expert_id"));
        System.out.println(param.get("topic_id"));
        System.out.println(param.get("appoint_time"));
        System.out.println(param.get("price"));
        return orderService.CreateOrder(param.get("customer_id"),param.get("expert_id"),param.get("topic_id"),param.get("appoint_time"),param.get("price"));
    }

    @PostMapping("/DeleteOrder")
    public boolean DeleteOrder(@RequestParam Map<String, Object> param) {
        return orderService.DeleteOrder(param.get("customer_id"),param.get("order_id"));
    }

    @PostMapping("/ModifyOrderStatusToFinish")
    public boolean ModifyOrderStatusToFinish(@RequestParam Map<String, Object> param) {
        return orderService.ModifyOrderStatusToFinish(param.get("customer_id"),param.get("order_id"));
    }

    @PostMapping("/ModifyOrderStatusToReview")
    public boolean ModifyOrderStatusToReview(@RequestParam Map<String, Object> param) {
        return orderService.ModifyOrderStatusToReview(param.get("customer_id"),param.get("order_id"));
    }


}
