package com.pointedInquery.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pointedInquery.entity.FavoritedirsExpert;
import com.pointedInquery.service.FavoritedirsExpertService;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/favoritedirs-expert")
public class FavoritedirsExpertController {

    @Autowired
    private FavoritedirsExpertService favoritedirsExpertService;

    @PostMapping("/GetDirsByUserid")
    public List<FavoritedirsExpert> GetDirsByUserid(@RequestParam Map<String, Object> param){
        return favoritedirsExpertService.GetDirsByUserid(param.get("customer_id"));
    }

    @PostMapping("/DeleteDirsByUserid")
    public boolean DeleteDirsByUserid(@RequestParam Map<String, Object> param){
        return favoritedirsExpertService.DeleteDirsByUserid(param.get("customer_id"),param.get("expert_id"));
    }

    @PostMapping("/CreateDirsByUserid")
    public boolean CreateDirsByUserid(@RequestParam Map<String, Object> param){
        return favoritedirsExpertService.CreateDirsByUserid(param.get("customer_id"),param.get("expert_id"));
    }

}
