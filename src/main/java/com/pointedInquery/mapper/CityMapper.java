package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.City;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {
	@Select("select cname from city where pid=#{pid} and cid=#{cid}")
	@ResultType(String.class)
	public String findById(@Param(value = "pid")int pid,@Param(value = "cid")int cid);
}
