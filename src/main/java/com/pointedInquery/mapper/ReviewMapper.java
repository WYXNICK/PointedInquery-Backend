package com.pointedInquery.mapper;

import com.pointedInquery.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Review;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper extends BaseMapper<Review> {
    @Select("select * from review where expert_id=#{phone}")
    public List<Review> selectReviewByExpert(String phone);
}
