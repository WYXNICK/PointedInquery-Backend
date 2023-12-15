package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Complaint;

@Mapper
public interface ComplaintMapper extends BaseMapper<Complaint> {

    @Insert("INSERT INTO complaint (order_id,user_id,be_user_id,state,contents,time) values (#{orderId},#{userId},#{beUserId},#{state},#{contents},#{time})")
    public int addComplaint(Complaint complaint);
}
