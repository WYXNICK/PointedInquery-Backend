package com.pointedInquery.service.impl;

import com.pointedInquery.entity.Expert;
import com.pointedInquery.entity.Topic;
import com.pointedInquery.mapper.ExpertMapper;
import com.pointedInquery.service.ExpertService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class ExpertServiceImpl extends ServiceImpl<ExpertMapper, Expert> implements ExpertService {
    @Autowired
    private ExpertMapper expertMapper;

    @Override
    public Expert getOneExpert(String phone) {
        return expertMapper.selectExpertByExpertId(phone);
    }

    @Override
    public List<Expert> listByType(int type) {
        return expertMapper.selectByType(type);
    }

    @Override
    public List<Expert> listCollectDir(String userID) {
        return expertMapper.selectCollectExpert(userID);
    }

    public static class ExpertWithTopics {
        private String phone;
        private String realName;
        private Float rating;
        private String description;
        private String id;
        private String job;
        private Integer price;
        private Integer type;
        private List<Topic> topics;

        public ExpertWithTopics() {
            // 无参构造函数
        }
        public ExpertWithTopics(Expert expert, List<Topic> topics) {
            this.phone = expert.getPhone();
            this.realName = expert.getRealName();
            this.rating = expert.getRating();
            this.description = expert.getDescription();
            this.id = expert.getId();
            this.job = expert.getJob();
            this.price = expert.getPrice();
            this.type = expert.getType();
            this.topics = topics;
        }

        // 公共的getter方法

        public String getPhone() {
            return phone;
        }

        public String getRealName() {
            return realName;
        }

        public Float getRating() {
            return rating;
        }

        public String getDescription() {
            return description;
        }

        public String getId() {
            return id;
        }

        public String getJob() {
            return job;
        }

        public Integer getPrice() {
            return price;
        }

        public Integer getType() {
            return type;
        }

        public List<Topic> getTopics() {
            return topics;
        }
    }

    @Override
    public List<ExpertWithTopics> getExpertsWithTopics(String searchString) {
        List<Expert> experts = expertMapper.selectExperts(searchString);
        List<ExpertWithTopics> expertWithTopicsList = new ArrayList<>();

        for (Expert expert : experts) {
            List<Topic> topics = expertMapper.selectTopicsByExpertId(expert.getPhone());
            expertWithTopicsList.add(new ExpertWithTopics(expert, topics));
        }

        return expertWithTopicsList;
    }


}
