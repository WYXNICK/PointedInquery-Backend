package com.pointedInquery.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pointedInquery.entity.City;
import com.pointedInquery.service.CityService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/city")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@GetMapping("/getAll")
	public List<City> getAll(int pid){
		LambdaQueryWrapper<City> lambdaQueryWrapper=new LambdaQueryWrapper<City>();
		lambdaQueryWrapper.eq(City::getPid, pid);
		return cityService.list(lambdaQueryWrapper);
	}

	
	@PostMapping("/getOne")
	public String getOne(int pid,int cid) {
		return cityService.findById(pid, cid);
	}

	@GetMapping("/ok")
	public String getok() {
		return "ok";
	}
}
