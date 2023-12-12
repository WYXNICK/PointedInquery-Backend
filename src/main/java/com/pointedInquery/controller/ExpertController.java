package com.pointedInquery.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pointedInquery.entity.Topic;
import com.pointedInquery.service.impl.ExpertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pointedInquery.entity.Expert;
import com.pointedInquery.service.ExpertService;

import java.util.List;
import java.util.Map;

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

	//根据前端传入的type返回属于这个类型的专家
	@GetMapping("/getAll")
	public List<Expert> getAll(@RequestParam int type) {
		return expertService.listByType(type);
	}

//	在expert里加入一个方法，接受的参数为用户id，返回用户收藏的所有专家列表，每一个元素是专家的所有信息
	@GetMapping("/user-collection")
	public List<Expert> getUserCollection(@RequestParam String userID) {
		return expertService.listCollectDir(userID);
	}

//	后端返回的data是一个数组，表示所有匹配的专家信息，包括realName，job，topic数组（表示一个专家包含的所有topic）,price
	@GetMapping("/search")
	public List<ExpertServiceImpl.ExpertWithTopics> searchExpert(@RequestParam String content) {
		return expertService.getExpertsWithTopics(content);
	}

	@GetMapping("/getOne")
	public Expert getOne(String userId) {
		return expertService.getOneExpert(userId);
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
