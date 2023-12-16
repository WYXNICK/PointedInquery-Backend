package com.pointedInquery.controller;



import com.pointedInquery.dto.OrderCreateDto;
import com.pointedInquery.dto.OrderDetailedInfoDto;
import com.pointedInquery.entity.Order;
import com.pointedInquery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /*
    我的订单
    */
    @GetMapping("/GetOrderByID")
    public List<OrderDetailedInfoDto> GetOrderByID(@RequestParam String customerId) {
        return orderService.GetOrderByID(customerId);
    }
    @GetMapping("/GetOrderByExpertID")
    public List<OrderDetailedInfoDto> GetOrderByExpertID(@RequestParam String expert_id) {
        return orderService.GetOrderByExpertID(expert_id);
    }

    /*
    已修改
     */
    @PostMapping("/CreateOrder")
    public boolean CreateOrder(@RequestBody OrderCreateDto orderCreateDto) {
        return orderService.CreateOrder(orderCreateDto.getCustomer_id(),orderCreateDto.getExpert_id(),orderCreateDto.getTopic_id(),orderCreateDto.getAppoint_time(),orderCreateDto.getPrice());
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

    @PostMapping("/CancleOrder")
    public int CancleOrder(@RequestParam String orderId){
        return orderService.CancleOrder(orderId);
    }


}
