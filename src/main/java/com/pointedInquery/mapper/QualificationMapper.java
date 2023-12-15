package com.pointedInquery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pointedInquery.entity.Qualification;

@Mapper
public interface QualificationMapper extends BaseMapper<Qualification> {
	@Update("update qualification set photo=#{url} where qid=#{qid} and phone=#{userId}")
	public int upload(@RequestParam(value = "url")String url,
			@RequestParam(value = "qid")String qid,
			@RequestParam(value = "userId")String userId);
	
	@Select("select * from qualification where phone=#{userId} and qid=#{qid}")
	public Qualification findOneByPhone(String userId,String qid);
	
	@Update("update qualification set state=#{state} where qid=#{qid} and phone=#{userId}")
	public int check(@RequestParam(value = "state")String state,
			@RequestParam(value = "qid")String qid,
			@RequestParam(value = "userId")String userId);
}
