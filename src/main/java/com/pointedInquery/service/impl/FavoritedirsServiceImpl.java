package com.pointedInquery.service.impl;

import com.pointedInquery.dto.ExpertDetailedDto;
import com.pointedInquery.entity.*;
import com.pointedInquery.mapper.*;
import com.pointedInquery.service.FavoritedirsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class FavoritedirsServiceImpl extends ServiceImpl<FavoritedirsMapper, Favoritedirs> implements FavoritedirsService {
    @Autowired
    private ExpertMapper expertMapper;

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private FavoritedirsMapper favoritedirsMapper;

    @Autowired
    private ExpertServiceImpl expertService;

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<ExpertDetailedDto> GetDirsByUserid(String phone) {
        List<Favoritedirs> favoritedirs = favoritedirsMapper.selectExpertList(phone);
        List<ExpertDetailedDto> expertDetailedDtos = new ArrayList<>();
        for(Favoritedirs favoritedir:favoritedirs) {
            Expert expert = expertMapper.selectExpertByExpertId(favoritedir.getExpertId()); // TODO,此处是phone还是expertid
            List<Topic> topics = topicMapper.selectTopicByExpert(favoritedir.getExpertId());
            List<Review> reviewList = reviewMapper.selectReviewByExpert(favoritedir.getExpertId());
            List<HashMap<String,Object>> reviews=new ArrayList<>();
            for(Review review : reviewList){
                HashMap<String,Object> reviewDetail =new HashMap<>();
                reviewDetail.put("id",review.getId());
                reviewDetail.put("userId",review.getUserId());
                reviewDetail.put("expertId",review.getExpertId());
                reviewDetail.put("topicId",review.getTopicId());
                reviewDetail.put("text",review.getText());
                reviewDetail.put("time",review.getTime());
                reviewDetail.put("orderId",review.getOrderId());
                reviewDetail.put("score",review.getScore());
                reviewDetail.put("name",userMapper.selectNameById(review.getUserId()));
                reviews.add(reviewDetail);
            }
            int lowestPrice = expertService.getLowestPrice(favoritedir.getExpertId());
            expertDetailedDtos.add(new ExpertDetailedDto(favoritedir.getExpertId(),expert.getRealName(), expert.getRating(), expert.getDescription(), expert.getId(),
                    expert.getJob(), lowestPrice ,expert.getType(), topics, reviews));
        }
        return expertDetailedDtos;
    }

    @Override
    public boolean DeleteDirsByUserid(String phone, String expert_id) {
        int deleteNum = favoritedirsMapper.deleteFavoriteDirByPhoneAndExpertId(phone, expert_id);
        if (deleteNum >= 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean CreateDirsByUserid(String phone, String expert_id) {
        //如果收藏夹记录里没有，且新增收藏成功，则新增收藏具体信息
        if(favoritedirsMapper.selectFavoriteDirNum(phone, expert_id) >= 1) {
            return false;
        }
        else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = LocalDateTime.now().format(formatter);
            favoritedirsMapper.insertFavoriteDir(phone, expert_id, formattedTime);
            return true;
        }
    }
}
