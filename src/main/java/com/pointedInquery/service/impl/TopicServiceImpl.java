package com.pointedInquery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pointedInquery.entity.Topic;
import com.pointedInquery.mapper.TopicMapper;
import com.pointedInquery.service.TopicService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {
	@Autowired
	private TopicMapper topicMapper;
	
	@Override
	public boolean check(String state, String topicId) {
		if (topicMapper.check(state, topicId)>0)
			return true;
		else {
			return false;
		}
	}

	@Override
	public Integer addTopic(String expertId, String title, String text, Integer price, String way) {
		Topic topic = new Topic();
		topic.setExpertId(expertId);
		topic.setTitle(title);
		topic.setText(text);
		topic.setPrice(price);
		topic.setWay(way);
		topic.setState("未审核");

		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=df.format(new Date());
		topic.setTopicTime(date);

		String topic_id= UUID.randomUUID().toString().toUpperCase().replaceAll("-","");
		topic.setTopicId(topic_id);

		return topicMapper.insert(topic);
	}

	@Override
	public Integer refactorTopic(String topicId, String title, String text, Integer price, String way) {
		return topicMapper.updateTopic(topicId, title, text, price, way);
	}

	@Override
	public Integer deleteTopic(String topicId) {
		return topicMapper.deleteTopic(topicId);
	}

	@Override
	public List<Topic> getTopicByExpertId(String expertId) {
		return topicMapper.selectTopicByExpert(expertId);
	}


}
