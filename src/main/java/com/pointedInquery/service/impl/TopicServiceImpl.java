package com.pointedInquery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pointedInquery.entity.Topic;
import com.pointedInquery.mapper.TopicMapper;
import com.pointedInquery.service.TopicService;

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
		if(topicMapper.check(state, topicId)>0)
			return true;
		else {
			return false;
		}
	}
}
