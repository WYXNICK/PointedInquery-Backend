package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Province;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
@Mapper
public interface ProvinceMapper extends BaseMapper<Province> {
	@Select("select pname from province where pid=#{pid}")
	@ResultType(String.class)
	public String findById(@Param(value="pid")int pid);
}
