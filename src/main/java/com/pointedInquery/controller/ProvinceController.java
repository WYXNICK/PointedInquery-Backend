package com.pointedInquery.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pointedInquery.entity.Province;
import com.pointedInquery.service.ProvinceService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
	@Autowired
	private ProvinceService provinceService;
	
	@GetMapping("/getAll")
	public List<Province> getAll(){
		return provinceService.list();
	}
	
	@PostMapping("/getOne")
	public String getOne(int pid) {
		return provinceService.findById(pid);
	}
}
