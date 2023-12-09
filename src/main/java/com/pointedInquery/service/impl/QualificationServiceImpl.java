package com.pointedInquery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pointedInquery.entity.Qualification;
import com.pointedInquery.mapper.QualificationMapper;
import com.pointedInquery.service.QualificationService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class QualificationServiceImpl extends ServiceImpl<QualificationMapper, Qualification> implements QualificationService {
	@Autowired
	private QualificationMapper qualificationMapper;
	
	//将上传图片生成的地址保存到数据库
	@Override
	public boolean upload(String url,String qid,String userId) {
		if(qualificationMapper.upload(url, qid,userId)>0)
			return true;
		else {
			return false;
		}
	}

	@Override
	public Qualification findOneByPhone(String userId,String qid) {
		return qualificationMapper.findOneByPhone(userId,qid);
	}

	@Override
	public boolean check(String state, String qid, String userId) {
		if(qualificationMapper.check(state, qid, userId)>0)
			return true;
		else {
			return false;
		}
	}

}
