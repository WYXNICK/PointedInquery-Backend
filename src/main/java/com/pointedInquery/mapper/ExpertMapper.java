package com.pointedInquery.mapper;

import com.pointedInquery.dto.AddExpertDto;
import com.pointedInquery.entity.Topic;
import org.apache.ibatis.annotations.*;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Expert;

import java.util.List;


@Mapper
public interface ExpertMapper extends BaseMapper<Expert> {
    @Select(" SELECT * FROM expert WHERE type = #{type}")
    public List<Expert> selectByType(int type);

    @Select("SELECT e.* FROM expert e JOIN favoritedirs f ON e.phone = f.expert_id WHERE f.phone = #{userID}")
    public List<Expert> selectCollectExpert(String userID);

    @Select("SELECT * FROM expert WHERE real_name LIKE CONCAT('%', #{searchString}, '%')")
    List<Expert> selectExperts(String searchString);

    @Select("SELECT * FROM topic WHERE expert_id = #{expertId}")
    List<Topic> selectTopicsByExpertId(String expertId);

    @Select("SELECT * FROM expert WHERE phone = #{expertId}")
    Expert selectExpertByExpertId(String expertId);

    @Select("SELECT * FROM expert WHERE id = #{id}")
    Expert selectExpertById(String id);

    @Update("UPDATE expert set real_name=#{realName},description=#{description},job=#{job} where phone=#{phone}")
    int updateExpertInfo(AddExpertDto addExpertDto);
}
