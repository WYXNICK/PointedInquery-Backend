package com.pointedInquery.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.api.R;
import com.pointedInquery.entity.Order;
import com.pointedInquery.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pointedInquery.entity.Review;
import com.pointedInquery.mapper.ReviewMapper;
import com.pointedInquery.service.ReviewService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private OrderMapper orderMapper;



    /*
     * 根据topic_id查找话题下所有的评论
     * */
    @Override
    public List<Review> GetReviewByTopicID(Object topic_id){
        QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("topic_id",topic_id.toString());

        List<Review> reviews=reviewMapper.selectList(queryWrapper);

        return reviews;
    }

    /*
     * 新建一条评论
     * */
    @Override
    public boolean CreateReview(Object user_id,Object expert_id,Object topic_id,String order_id,Object text, Object score){
        Review review = new Review();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=dateFormat.format(date);
        review.setTime(time);
        review.setUserId((String)user_id);
        review.setExpertId((String) expert_id);
        review.setTopicId((String)topic_id);
        review.setOrderId((String)order_id);
        review.setText((String)text);
        review.setScore((float) score);

        System.out.println(review.toString());


        int insert= reviewMapper.insert(review);

        if(insert>=1) {
            orderMapper.updateOrderStatus("已评价",order_id);
            return true;  //创建成功
        }
        else
            return false;  //创建失败
    }

    /*
     * 根据id删除一条评论
     * */
    @Override
    public boolean DeleteReview(Object id){
        QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id.toString());

        int delete= reviewMapper.delete(queryWrapper);

        if(delete>=1)
            return true;  //删除成功
        else
            return false;  //删除失败
    }

    /*
     * 根据id修改评论内容
     * */
    @Override
    public boolean ModifyReview(Object id,Object text){
        QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id.toString());

        Review review=reviewMapper.selectOne(queryWrapper);
        review.setText((String) text);

        int update= reviewMapper.update(review,queryWrapper);

        if(update>=1)
            return true;
        else
            return false;
    }

    @Override
    public List<Review> GetReviewByExpertID(String expertId){
        return reviewMapper.selectReviewByExpert(expertId);
    }

}
