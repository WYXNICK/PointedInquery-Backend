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
    public List<FavoritedirsExpert> GetDirsByUserid(Object customer_id){
        QueryWrapper<FavoritedirsExpert> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id.toString());

        List<FavoritedirsExpert> favoritedirsExperts=favoritedirsExpertMapper.selectList(queryWrapper);

        return favoritedirsExperts;
    }
    @Override
    public boolean DeleteDirsByUserid(Object customer_id, Object expert_id){
        QueryWrapper<FavoritedirsExpert> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id.toString());
        queryWrapper.eq("expert_id",expert_id.toString());
        int delete=favoritedirsExpertMapper.delete(queryWrapper);
        if(delete>=1)
            return true;//删除成功
        else
            return false;//删除失败
    }


    @Override
    public boolean CreateDirsByUserid(Object customer_id, Object expert_id){
        //排除重复填加收藏单
        QueryWrapper<FavoritedirsExpert> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id",customer_id.toString());
        queryWrapper.eq("expert_id",expert_id.toString());

        List<FavoritedirsExpert> favoritedirsExperts=favoritedirsExpertMapper.selectList(queryWrapper);
        if(favoritedirsExperts.size()!=0)
            return false; //心愿单中已存在该行家，请勿重复收藏

        //创建新的收藏
        FavoritedirsExpert favoritedirsExpert=new FavoritedirsExpert();
        favoritedirsExpert.setCustomerId((String) customer_id);
        favoritedirsExpert.setExpertId((String) expert_id);

        //expert表里查询
        QueryWrapper<Expert> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("phone",expert_id.toString());
        Expert expert=expertMapper.selectOne(queryWrapper2);
        favoritedirsExpert.setJob(expert.getJob());
        favoritedirsExpert.setRealName(expert.getRealName());
        favoritedirsExpert.setRating(expert.getRating());

        //topic表里查询信息
        QueryWrapper<Topic> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("expert_id",expert_id.toString());
        List<Topic> topics=topicMapper.selectList(queryWrapper3);
        favoritedirsExpert.setPrice(topics.get(0).getPrice());
        String titlenew="";
        for (int i = 0; i < topics.size(); i++) {
            titlenew=titlenew+topics.get(i)+";";
        }
        favoritedirsExpert.setTitle(titlenew);//TODO:将行家topic下的所有title汇总到favoritedirs中

        //user表里查询addr_province
        QueryWrapper<User> queryWrapper4 = new QueryWrapper<>();
        queryWrapper4.eq("phone",expert_id.toString());
        User user=userMapper.selectOne(queryWrapper4);
        favoritedirsExpert.setAddrProvince(user.getAddrProvince());

        int insert=favoritedirsExpertMapper.insert(favoritedirsExpert);
        if(insert>=1)
            return true;//删除成功
        else
            return false;//删除失败
    }
}
