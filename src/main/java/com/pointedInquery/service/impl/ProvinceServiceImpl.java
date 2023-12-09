package com.pointedInquery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pointedInquery.entity.Province;
import com.pointedInquery.mapper.ProvinceMapper;
import com.pointedInquery.service.ProvinceService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {
	@Autowired
	private ProvinceMapper provinceMapper;
	
	public String findById(int pid) {
		return provinceMapper.findById(pid);
	}
}
