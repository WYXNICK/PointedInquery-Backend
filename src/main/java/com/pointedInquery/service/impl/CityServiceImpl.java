package com.pointedInquery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pointedInquery.entity.City;
import com.pointedInquery.mapper.CityMapper;
import com.pointedInquery.service.CityService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
	@Autowired
	private CityMapper cityMapper;
	
	public String findById(int pid,int cid) {
		return cityMapper.findById(pid, cid);
	}
}
