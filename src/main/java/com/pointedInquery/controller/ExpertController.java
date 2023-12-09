package com.pointedInquery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pointedInquery.entity.Expert;
import com.pointedInquery.service.ExpertService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/expert")
public class ExpertController {
	@Autowired
	private ExpertService expertService;
	
	@PostMapping("/getOne")
	public Expert getOne(String userId) {
		return expertService.getById(userId);
	}
	
	@PostMapping("/addExpert")
	public boolean addExpert(String userId,String name,String ID) {
		Expert expert=new Expert();
		expert.setId(ID);
		expert.setPhone(userId);
		expert.setRealName(name);
		return expertService.save(expert);
	}
	
	//行家修改自己的个人描述
	@PostMapping("/changeInfo")
	public boolean changeInfo(String userId,String description) {
		Expert expert=new Expert();
		expert.setPhone(userId);
		expert.setDescription(description);
		return expertService.saveOrUpdate(expert);
	}
	
	//由管理员授予行家身份说明
	@PostMapping("/authJob")
	public boolean authJob(String userId,String job) {
		Expert expert=new Expert();
		expert.setPhone(userId);
		expert.setJob(job);
		return expertService.saveOrUpdate(expert);
	}
	
}
