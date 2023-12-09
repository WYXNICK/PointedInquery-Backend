package com.pointedInquery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pointedInquery.entity.Qualification;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface QualificationService extends IService<Qualification> {
	public boolean upload(String url,String qid,String userId);
	
	public Qualification findOneByPhone(String userId,String qid);
	
	public boolean check(String state,String qid,String userId);
}
