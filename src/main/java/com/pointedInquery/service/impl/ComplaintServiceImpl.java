package com.pointedInquery.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pointedInquery.entity.Complaint;
import com.pointedInquery.mapper.ComplaintMapper;
import com.pointedInquery.service.ComplaintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements ComplaintService {
    @Autowired
    private ComplaintMapper complaintMapper;

    /*
    * 创建投诉，先查询投诉是否已存在，若不存在则创建新的投诉
    * */
    @Override
    public int CreateComplaint(Object order_id, Object user_id, Object be_user_id,Object contents){
        QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id",order_id.toString());
        queryWrapper.eq("user_id",user_id.toString());
        queryWrapper.eq("be_user_id",be_user_id.toString());

        Complaint complaint =complaintMapper.selectOne(queryWrapper);  //查询到需要创建的订单
        if(complaint!=null){
            return 0;  //已存在投诉，请不要反复投诉
        }
        complaint=new Complaint();

        complaint.setOrderId((String) order_id);
        complaint.setUserId((String) user_id);
        complaint.setBeUserId((String) be_user_id);
        complaint.setState("未处理");
        complaint.setContents((String) contents);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        complaint.setTime(dateFormat.format(date));

        int insert = complaintMapper.insert(complaint);

        if(insert>=1)
            return 1;  //创建成功
        else
            return 2;  //创建失败
    }


    /*
     * 管理员修改投诉状态，先查询投诉是否存在，若存在则修改状态
     * */
    @Override
    public int ChangeStatusComplaintToPass(Object order_id, Object user_id, Object be_user_id){
        QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id",order_id.toString());
        queryWrapper.eq("user_id",user_id.toString());
        queryWrapper.eq("be_user_id",be_user_id.toString());

        Complaint complaint =complaintMapper.selectOne(queryWrapper);  //查询到需要创建的订单
        if(complaint==null){
            return 0;  //不存在投诉
        }

        complaint.setState("投诉通过");
        return  complaintMapper.update(complaint,queryWrapper);//审核通过，已修改

    }

    /*
     * 管理员修改投诉状态，先查询投诉是否存在，若存在则修改状态
     * */
    @Override
    public int ChangeStatusComplaintToBack(Object order_id, Object user_id, Object be_user_id){
        QueryWrapper<Complaint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id",order_id.toString());
        queryWrapper.eq("user_id",user_id.toString());
        queryWrapper.eq("be_user_id",be_user_id.toString());

        Complaint complaint =complaintMapper.selectOne(queryWrapper);  //查询到需要创建的订单
        if(complaint==null){
            return 0;  //不存在投诉
        }
        complaint.setState("驳回");
        return  complaintMapper.update(complaint,queryWrapper);//驳回，已修改

    }
}
