package com.pointedInquery.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pointedInquery.common.ReturnCode;
import com.pointedInquery.common.ServerResponse;
import com.pointedInquery.entity.Qualification;
import com.pointedInquery.service.QualificationService;
import com.pointedInquery.service.UserService;

@RestController
@RequestMapping("/qualification")
public class QualificationController {
	//服务器上的文件保存路径
	private final String address="E:/";
	
	@Autowired
	private QualificationService qualificationService;
	@Autowired
	private UserService userService;
	
	/**
	 * 上传图片
	 * @param files
	 * @param qid
	 * @param userId
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/uploadPhoto")
	public boolean uploadPhoto(MultipartFile[] files,String qid,String userId) throws IOException {
		//记录所有图片url
		StringBuilder builder=new StringBuilder();
		//允许上传多个图片
		for(int i=1;i<=files.length;i++) {
			if(i>1)
				builder.append(",");
			//获取图片原名
			String originName=files[i-1].getOriginalFilename();
			if(originName!=null) {
				//获得扩展名
				String extend=originName.substring(originName.lastIndexOf("."));
				//生成唯一的图片名称
				String newName=address+UUID.randomUUID().toString().toUpperCase().replaceAll("-","")+extend;
				//拼接新的图片存放地址
				File uploadFile=new File(newName);
				//保存图片
				files[i-1].transferTo(uploadFile);
				builder.append(newName);
			}
		}
		return qualificationService.upload(builder.toString(), qid, userId);
	}

	
	/**
	 * 根据用户id查找相关资质信息
	 * @param userId
	 * @return
	 */
	@PostMapping("/getByPhone")
	public List<Qualification> getByPhone(String userId){
		LambdaQueryWrapper<Qualification> lambdaQueryWrapper=new LambdaQueryWrapper<Qualification>();
		lambdaQueryWrapper.eq(Qualification::getPhone,userId);
		return qualificationService.list(lambdaQueryWrapper);
	}
}
