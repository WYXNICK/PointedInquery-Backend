package com.pointedInquery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pointedInquery.common.ReturnCode;
import com.pointedInquery.common.ServerResponse;
//import com.pointedInquery.config.LoginInterceptor;
import com.pointedInquery.entity.User;
import com.pointedInquery.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//对密码进行MD5加密
	private String getMD5Str(String passwd) {
		return DigestUtils.md5DigestAsHex(passwd.getBytes());
	}
	
	//调用第三方接口验证
	@PostMapping("/becomeExpert")
	public boolean becomeExpert(String userId,String name,String ID) {
		return userService.beExpert(userId);
	}
	
	@PostMapping("/login")
	public ServerResponse<String> login(String userId,String passwd){
		//用户账号不存在

		System.out.println(userId);
		System.out.println(passwd);

		if(userId==null||userService.count()==0) {
			return ServerResponse.failure(ReturnCode.USERID_OR_PASSWORD_ERROR);
		}
		User user=userService.getById(userId);
		System.out.println("userId: "+getMD5Str(passwd));
		System.out.println("database: "+user.getPassword());
		//密码错误
		if(!getMD5Str(passwd).equals(user.getPassword())) {
			return ServerResponse.failure(ReturnCode.USERID_OR_PASSWORD_ERROR);
		}
		//String token=LoginInterceptor.GenerateToken(userId);
		return ServerResponse.success("hhh");
	}
	
	@PostMapping("/register")
	public ServerResponse<Boolean> register(String userId,String passwd){
		System.out.println(userId);
		System.out.println(passwd);

		if(userId==null||passwd==null) {
			return ServerResponse.failure(ReturnCode.INFO_EMPTY);
		}
		//账号没有被注注册过
		if(userService.getById(userId)!=null) {
			return ServerResponse.failure(ReturnCode.USERID_USED);
		}
		User user=new User();
		//刚注册用户不会有行家权限
		user.setPhone(userId);
//		user.setIsexpert("否");
		//对密码进行加密
		user.setPassword(getMD5Str(passwd));
		if(userService.save(user))
			return ServerResponse.success(null);
		else {
			return ServerResponse.failure(ReturnCode.RC999);
		}
	}

	//返回用户个人信息，同时将密码设为null避免泄露
	@PostMapping("/myInfo")
	public User myInfo(@RequestParam String userId) {
		User user = userService.getById(userId);
		//保护密码
		user.setPassword(null);
		return user;
	}
	
	@PostMapping("/changeInfo")
	public boolean changeInfo(@RequestBody User user){
		return userService.saveOrUpdate(user);
	}
	
	@PostMapping("/changePasswd")
	public ServerResponse<Boolean> changePasswd(String userId,String oldPasswd,String newPasswd) {
		//密码错误
		if(userService.getById(userId).getPassword()!=getMD5Str(oldPasswd)) {
			return ServerResponse.failure(ReturnCode.USERID_OR_PASSWORD_ERROR);
		}
		//进行修改
		if(userService.changePasswd(newPasswd, userId)>0) {
			return ServerResponse.success(null);
		}
		else {
			return ServerResponse.failure(ReturnCode.RC999);
		}
	}
	
	//removeById的使用前提是，Mapper中标明了主键
	@PostMapping("/deleteByPhone")
	public boolean deleteByPhone(String userId) {
		return userService.removeById(userId);
	}
}
