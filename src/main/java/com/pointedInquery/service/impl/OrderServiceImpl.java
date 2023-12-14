package com.pointedInquery.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pointedInquery.dto.OrderDetailedInfoDto;
import com.pointedInquery.entity.Expert;
import com.pointedInquery.entity.Order;
import com.pointedInquery.entity.Topic;
import com.pointedInquery.mapper.ExpertMapper;
import com.pointedInquery.mapper.OrderMapper;
import com.pointedInquery.mapper.TopicMapper;
import com.pointedInquery.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ExpertMapper expertMapper;
    @Autowired
    private TopicMapper topicMapper;

    /*
     * 根据customer_id查找该用户所有的订单
     * */
    @Override
    public List<OrderDetailedInfoDto> GetOrderByID(Object customer_id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id);
        List<OrderDetailedInfoDto> dtoList=new ArrayList<>();
        List<Order> orderList= orderMapper.selectList(queryWrapper);
        for(Order order : orderList){
            String expertId= order.getExpertId();
            String topicId=order.getTopicId();
            Expert expert=expertMapper.selectById(expertId);
            Topic topic=topicMapper.selectById(topicId);
            String realName=expert==null?"":expert.getRealName();
            String title=topic==null?"":topic.getTitle();
            OrderDetailedInfoDto dto=new OrderDetailedInfoDto(order.getOrderId(),order.getCustomerId(),order.getExpertId()
            ,order.getTopicId(),order.getPayTime(),order.getAppointTime(),order.getState(),order.getPrice(),realName,title);
            dtoList.add(dto);
        }
        return dtoList;
    }

    /*
     * 根据expert_id查找该用户所有的订单
     * */
    @Override
    public List<Order> GetOrderByExpertID(Object expert_id){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("expert_id",expert_id.toString());

        return orderMapper.selectList(queryWrapper);

    }

    @Override
    public  boolean CreateOrder(Object customer_id, Object expert_id, Object topic_id, Object appoint_time, Object price){
        Order order=new Order();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        order.setPayTime(dateFormat.format(date));
        order.setCustomerId((String) customer_id);
        order.setExpertId((String) expert_id);
        order.setTopicId((String) topic_id);
        order.setAppointTime((String) appoint_time);
        order.setPrice((int)price);
        order.setState("进行中");
        int insert= orderMapper.insert(order);

        if(insert>=1)
            return true;  //创建成功
        else
            return false;  //创建失败
    }

    @Override
    public boolean DeleteOrder(Object customer_id, Object order_id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id.toString());
        queryWrapper.eq("order_id",order_id.toString());

        List<Order> orders=orderMapper.selectList(queryWrapper);
        if(orders.isEmpty())
            return false; //没有查找到该order

        int delete=orderMapper.delete(queryWrapper);
        if(delete>=1)
            return true;  //删除成功
        else
            return false;  //删除失败
    }

    @Override
    public boolean ModifyOrderStatusToFinish(Object customer_id, Object order_id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id.toString());
        queryWrapper.eq("order_id",order_id.toString());

        Order order=orderMapper.selectOne(queryWrapper);

        if(order==null)
            return false; //没有查找到该order

        order.setState("已完成");
        int update=orderMapper.update(order,queryWrapper);

        if(update>=1)
            return true;  //修改状态成功
        else
            return false;  //修改状态失败
    }

    @Override
    public boolean ModifyOrderStatusToReview(Object customer_id, Object order_id){
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id.toString());
        queryWrapper.eq("order_id",order_id.toString());

        Order order=orderMapper.selectOne(queryWrapper);

        if(order==null)
            return false; //没有查找到该order

        order.setState("已评价");
        int update=orderMapper.update(order,queryWrapper);

        if(update>=1)
            return true;  //修改状态成功
        else
            return false;  //修改状态失败
    }

}
