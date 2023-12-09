package com.pointedInquery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pointedInquery.entity.Province;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface ProvinceService extends IService<Province> {
	public String findById(int pid);
}
