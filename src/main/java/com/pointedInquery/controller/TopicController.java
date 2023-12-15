package com.pointedInquery.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pointedInquery.common.ReturnCode;
import com.pointedInquery.common.ServerResponse;
import com.pointedInquery.entity.Topic;
import com.pointedInquery.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
	@Autowired
	private TopicService topicService;

	@PostMapping("/addTopic")
	public Integer addTopic(String expertId, String title, String text, Integer price, String way) {
		return topicService.addTopic(expertId, title,text, price, way);
	}

	@PostMapping("/refactorTopic")
	public Integer refactorTopic(String topicId, String title, String text, Integer price, String way) {
		return topicService.refactorTopic(topicId, title,text, price, way);
	}

	@PostMapping("/deleteTopic")
	public Integer deleteTopic(String topicId) {
		return topicService.deleteTopic(topicId);
	}

	@GetMapping("/getAllTopicByExpertId")
	public List<Topic> getAllTopicByExpertId(String expertId) {
		return topicService.getTopicByExpertId(expertId);
	}

}
