package com.pointedInquery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pointedInquery.entity.Topic;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface TopicService extends IService<Topic> {
	public boolean check(String state,String topicId);
	public Integer addTopic(String expertId, String title, String text, Integer price, String way);
	public Integer refactorTopic(String topicId, String title, String text, Integer price, String way);
	public Integer deleteTopic(String topicId);
}
