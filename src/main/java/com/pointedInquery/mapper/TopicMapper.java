package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Topic;
import java.util.List;

@Mapper
public interface TopicMapper extends BaseMapper<Topic> {
	@Update("update topic set state=#{state} where topic_id=#{topicId}")
	public int check(@RequestParam(value = "state")String state,
			@RequestParam(value = "topicId")String topicId);

	@Select("select * from topic where expert_id=#{phone}")
	public List<Topic> selectTopicByExpert(String phone);

	@Select("SELECT price FROM topic WHERE expert_id = #{expert_id} ORDER BY price ASC LIMIT 1")
	Integer getLowestPriceByExpertId(String expert_id);

	@Update("UPDATE topic SET title = #{title}, text = #{text}, price = #{price}, way = #{way} WHERE topic_id = #{topicId}")
	int updateTopic(String topicId, String title, String text, Integer price, String way);

	@Delete(" DELETE FROM topic WHERE topic_id = #{topicId}")
	int deleteTopic(String topicId);
}
