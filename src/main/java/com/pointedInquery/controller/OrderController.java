package com.pointedInquery.controller;



import com.pointedInquery.dto.OrderDetailedInfoDto;
import com.pointedInquery.entity.Order;
import com.pointedInquery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/GetOrderByID")
    public List<OrderDetailedInfoDto> GetOrderByID(@RequestParam String customer_id) {
        return orderService.GetOrderByID(customer_id);
    }
    @GetMapping("/GetOrderByExpertID")
    public List<Order> GetOrderByExpertID(@RequestParam String expert_id) {
        return orderService.GetOrderByExpertID(expert_id);
    }

    /*
    这个新增有问题，报500
     */
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

    /*
    下面两个修改有问题，报500
   */
    @PostMapping("/ModifyOrderStatusToFinish")
    public boolean ModifyOrderStatusToFinish(@RequestParam Map<String, Object> param) {
        return orderService.ModifyOrderStatusToFinish(param.get("customer_id"),param.get("order_id"));
    }

    @PostMapping("/ModifyOrderStatusToReview")
    public boolean ModifyOrderStatusToReview(@RequestParam Map<String, Object> param) {
        return orderService.ModifyOrderStatusToReview(param.get("customer_id"),param.get("order_id"));
    }


}
