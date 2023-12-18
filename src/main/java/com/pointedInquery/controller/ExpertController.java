package com.pointedInquery.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pointedInquery.dto.AddExpertDto;
import com.pointedInquery.dto.ExpertDetailedDto;
import com.pointedInquery.entity.Topic;
import com.pointedInquery.service.impl.ExpertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pointedInquery.entity.Expert;
import com.pointedInquery.service.ExpertService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expert")
public class ExpertController {
	@Autowired
	private ExpertService expertService;

	//根据前端传入的type返回属于这个类型的专家
	@GetMapping("/getAll")
	public List<ExpertServiceImpl.ExpertWithTopics> getAll(@RequestParam int type) {
		return expertService.listByType(type);
	}


//	后端返回的data是一个数组，表示所有匹配的专家信息，包括realName，job，topic数组（表示一个专家包含的所有topic）,price
	@GetMapping("/search")
	public List<ExpertServiceImpl.ExpertWithTopics> searchExpert(@RequestParam String content) {
		return expertService.getExpertsWithTopics(content);
	}

	@GetMapping("/getOne")
	public ExpertDetailedDto getOne(@RequestParam String expertId) {
		return expertService.getOneExpert(expertId);
	}

	
	//行家修改自己的个人信息
	@PostMapping("/changeInfo")
	public int changeInfo(AddExpertDto addExpertDto) {
		return expertService.saveOrUpdate(addExpertDto);
	}


	//个人申请成为行家
	@PostMapping("/addExpert")
	public int addExpert(AddExpertDto addExpertDto) {
		return expertService.addExpert(addExpertDto);
	}

}
