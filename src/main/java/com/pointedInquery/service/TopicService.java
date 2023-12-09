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
}
