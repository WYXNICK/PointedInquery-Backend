package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Expert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
public interface ExpertMapper extends BaseMapper<Expert> {
    @Select(" SELECT * FROM expert WHERE type = #{type}")
    public List<Expert> selectByType(int type);

    @Select("SELECT e.* FROM expert e JOIN favoritedirs f ON e.phone = f.expert_id WHERE f.phone = #{userID}")
    public List<Expert> selectCollectExpert(String userID);

}
