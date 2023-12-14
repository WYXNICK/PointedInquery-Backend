package com.pointedInquery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pointedInquery.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface UserService extends IService<User> {
	public int changePasswd(String newPasswd, String userId);
	
	public boolean IsExpert(String userId);
	
	public boolean beExpert(String userId);

	public int checkCollectDir(String userId, String expertId);
}
