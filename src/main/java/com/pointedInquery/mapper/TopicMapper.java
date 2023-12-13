package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Topic;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
public interface TopicMapper extends BaseMapper<Topic> {
	@Update("update topic set state=#{state} where topic_id=#{topicId}")
	public int check(@RequestParam(value = "state")String state,
			@RequestParam(value = "topicId")String topicId);

	@Select("select * from topic where expert_id=#{phone}")
	public List<Topic> selectTopicByExpert(String phone);
}
