package com.pointedInquery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pointedInquery.entity.User;
import com.pointedInquery.mapper.UserMapper;
import com.pointedInquery.service.UserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int changePasswd(String newPasswd, String userId) {
		return userMapper.changePasswd(newPasswd, userId);
	}

	@Override
	public boolean IsExpert(String userId) {
		return userMapper.IsExpert(userId);
	}

	@Override
	public boolean beExpert(String userId) {
		if(userMapper.beExpert(userId)>0)
			return true;
		else {
			return false;
		}
	}

	@Override
	public int checkCollectDir(String userId, String expertId) {
		return userMapper.existsByUserIdAndExpertId(userId, expertId);
	}

}
