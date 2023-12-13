package com.pointedInquery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pointedInquery.entity.Expert;
import com.pointedInquery.entity.FavoritedirsExpert;
import com.pointedInquery.entity.Topic;
import com.pointedInquery.entity.User;
import com.pointedInquery.mapper.ExpertMapper;
import com.pointedInquery.mapper.FavoritedirsExpertMapper;
import com.pointedInquery.mapper.TopicMapper;
import com.pointedInquery.mapper.UserMapper;
import com.pointedInquery.service.FavoritedirsExpertService;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 */
@Service
public class FavoritedirsExpertServiceImpl extends ServiceImpl<FavoritedirsExpertMapper, FavoritedirsExpert> implements FavoritedirsExpertService {
    @Autowired
    private FavoritedirsExpertMapper favoritedirsExpertMapper;

    @Autowired
    private ExpertMapper expertMapper;

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<FavoritedirsExpert> GetDirsByUserid(String customer_id){
        List<FavoritedirsExpert> favoritedirsExperts=favoritedirsExpertMapper.selectExpertList(customer_id);

        return favoritedirsExperts;
    }

    @Override
    public boolean DeleteDirsByUserid(String phone, String expert_id){
//        QueryWrapper<FavoritedirsExpert> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("customer_id",customer_id.toString());
//        queryWrapper.eq("expert_id",expert_id.toString());
//        int delete=favoritedirsExpertMapper.delete(queryWrapper);
//        if(delete>=1)
//            return true;//删除成功
//        else
//            return false;//删除失败
        return true;
    }


    @Override
    public boolean CreateDirsByUserid(String customer_id, String expert_id){
        //排除重复填加收藏单
//        QueryWrapper<FavoritedirsExpert> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("customer_id",customer_id.toString());
//        queryWrapper.eq("expert_id",expert_id.toString());
//
//        List<FavoritedirsExpert> favoritedirsExperts=favoritedirsExpertMapper.selectList(queryWrapper);
//        if(favoritedirsExperts.size()!=0)
//            return false; //心愿单中已存在该行家，请勿重复收藏
//
//        //创建新的收藏
//        FavoritedirsExpert favoritedirsExpert=new FavoritedirsExpert();
//        favoritedirsExpert.setCustomerId((String) customer_id);
//        favoritedirsExpert.setExpertId((String) expert_id);
//
//        //expert表里查询
//        QueryWrapper<Expert> queryWrapper2 = new QueryWrapper<>();
//        queryWrapper2.eq("phone",expert_id.toString());
//        Expert expert=expertMapper.selectOne(queryWrapper2);
//        favoritedirsExpert.setJob(expert.getJob());
//        favoritedirsExpert.setRealName(expert.getRealName());
//        favoritedirsExpert.setRating(expert.getRating());
//
//        //topic表里查询信息
//        QueryWrapper<Topic> queryWrapper3 = new QueryWrapper<>();
//        queryWrapper3.eq("expert_id",expert_id.toString());
//        List<Topic> topics=topicMapper.selectList(queryWrapper3);
//        favoritedirsExpert.setPrice(topics.get(0).getPrice());
//        String titlenew="";
//        for (int i = 0; i < topics.size(); i++) {
//            titlenew=titlenew+topics.get(i)+";";
//        }
//        favoritedirsExpert.setTitle(titlenew);//TODO:将行家topic下的所有title汇总到favoritedirs中
//
//        //user表里查询addr_province
//        QueryWrapper<User> queryWrapper4 = new QueryWrapper<>();
//        queryWrapper4.eq("phone",expert_id.toString());
//        User user=userMapper.selectOne(queryWrapper4);
//        favoritedirsExpert.setAddrProvince(user.getAddrProvince());
//
//        int insert=favoritedirsExpertMapper.insert(favoritedirsExpert);
//        if(insert>=1)
//            return true;//删除成功
//        else
//            return false;//删除失败

        List<String> favoriteExperts=favoritedirsExpertMapper.selectFavoriteExpertsById(customer_id);
        if (favoriteExperts.contains(expert_id)) {
            return false;
        } else {
            //如果收藏夹记录里没有，且新增收藏成功，则新增收藏具体信息
            if(favoritedirsExpertMapper.selectFavoriteExpertRecord(customer_id,expert_id)==0
                    && favoritedirsExpertMapper.addFavoriteExpert(customer_id, expert_id) != 0) {
                   Expert expert=expertMapper.selectById(expert_id);
                   User user=userMapper.selectById(customer_id);
                   FavoritedirsExpert fdExpert=new FavoritedirsExpert();
                   fdExpert.setCustomerId(customer_id);
                   fdExpert.setExpertId(expert.getId());
                   fdExpert.setJob(expert.getJob());
                   fdExpert.setPrice(expert.getPrice());
                   fdExpert.setRating(expert.getRating());
                   fdExpert.setRealName(expert.getRealName());
                   fdExpert.setType(expert.getType());
                   favoritedirsExpertMapper.addDetaiedInfo(fdExpert);
                   System.out.println(fdExpert);
                return true;
            }
            else
                return false;
        }
    }
}
