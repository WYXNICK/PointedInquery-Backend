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
	
	//管理员修改资质状态
//	@PostMapping("/check")
//	public boolean check(@RequestParam(value = "userId")String userId,
//			@RequestParam(value = "qid")String qid,@RequestParam(value = "state")String state) {
//		return qualificationService.check(state, qid, userId);
//	}
	
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
	 * 
	 * @param qualification 包含qid、用户id、资质名、资质内容
	 * @return 保存成功，返回qid
	 */
//	@PostMapping("/uploadInfo")
//	public ServerResponse<String> uploadInfo(Qualification qualification) {
//		String phone=qualification.getPhone();
//		String qid=qualification.getQid();
//		//用户还没有行家身份，或必填信息为空
//		if(!userService.IsExpert(phone)||phone==null||qid==null)
//			return ServerResponse.failure(ReturnCode.ACCESS_DENIED);
//
//		//资质领域是否重复
//		Qualification list=qualificationService.findOneByPhone(phone,qid);
//		if(list!=null) {
//			return ServerResponse.failure(ReturnCode.INFO_REPEAT);
//		}
//
//		qualification.setState("未审核");
//		//保存到数据库
//		if(qualificationService.save(qualification))
//			return ServerResponse.success(null);
//		else {
//			return ServerResponse.failure(ReturnCode.RC999);
//		}
//	}
	
	/**
	 * 修改已有资质信息
	 * @param qualification
	 * @param files
	 * @return
	 * @throws IOException
	 */
//	@PostMapping("/changeInfo")
//	public ServerResponse<Boolean> changeInfo(Qualification qualification,MultipartFile[] files) throws IOException {
//		//上传了图片，进行更新
//		if(files.length>0) {
//			String qid = qualification.getQid();
//			String photoURL = qualificationService.getById(qid).getPhoto();
//
//			//如果原来保存了图片
//			if(photoURL!=null) {
//				//先将原本的图片删除
//				String photoURLs[]=photoURL.split(",");
//				for(String url:photoURLs) {
//					File file=new File(url);
//					file.delete();
//				}
//			}
//
//			//再保存现在的图片
//			if(!uploadPhoto(files, qid,qualification.getPhone())) {
//				return ServerResponse.failure(ReturnCode.PHOTO_UPLOAD_FAILED);
//			}
//
//		}
//		if(qualificationService.saveOrUpdate(qualification)) {
//			return ServerResponse.success(null);
//		}
//		else {
//			return ServerResponse.failure(ReturnCode.RC999);
//		}
//	}
	
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
