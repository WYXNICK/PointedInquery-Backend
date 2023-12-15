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
	
	/**
	 * 自动生成topic_id
	 * @param topic
	 * expert_id,title,text,price,way,appoint_time
	 * @return
	 */
	@PostMapping("/addTopic")
	public boolean addTopic(Topic topic) {
		topic.setState("未审核");
		topic.setTalkedTimes(0);
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=df.format(new Date());
		topic.setTopicTime(date);
		
		String topic_id=UUID.randomUUID().toString().toUpperCase().replaceAll("-","");
		topic.setTopicId(topic_id);
		return topicService.save(topic);
	}
	
	//管理员修改审核状态
//	@PostMapping("/check")
//	public boolean check(@RequestParam(value = "state")String state,
//			@RequestParam(value = "topicId")String topicId) {
//		return topicService.check(state, topicId);
//	}
	
//	@PostMapping("/changeTopic")
//	public ServerResponse<Boolean> changeTopic(@RequestBody Topic topic) {
//		//确认是行家本人修改
//		String userId=topicService.getById(topic.getTopicId()).getExpertId();
//		if(userId!=topic.getExpertId()) {
//			return ServerResponse.failure(ReturnCode.ACCESS_DENIED);
//		}
//		if(topicService.saveOrUpdate(topic)) {
//			return ServerResponse.success(null);
//		}
//		else {
//			return ServerResponse.failure(ReturnCode.RC999);
//		}
//	}
	
	@GetMapping("/getById")
	public List<Topic> getById(@RequestParam String expertId){
		LambdaQueryWrapper<Topic> lambdaQueryWrapper=new LambdaQueryWrapper<Topic>();
		lambdaQueryWrapper.eq(Topic::getExpertId, expertId);
		return topicService.list(lambdaQueryWrapper);
	}

//	@PostMapping("/search")
//	public List<Topic> searchByKeyword(String keyword){
//		return
//	}

}
