package com.pointedInquery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pointedInquery.entity.City;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface CityService extends IService<City> {
	public String findById(int pid,int cid);
}
