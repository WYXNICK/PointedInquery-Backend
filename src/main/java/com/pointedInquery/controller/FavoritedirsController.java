package com.pointedInquery.controller;


import com.pointedInquery.dto.ExpertDetailedDto;
import com.pointedInquery.service.FavoritedirsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/favoritedirs-expert")
public class FavoritedirsController {

    @Autowired
    private FavoritedirsService favoritedirsService;
//    @GetMapping("/GetDirsByUserid")
//    public List<FavoritedirsExpertDto> GetDirsByUserid(@RequestParam String phone){
//        return favoritedirsService.GetDirsByUserid(phone);
//    }
    @PostMapping("/GetDirsByUserid")
    public List<ExpertDetailedDto> GetDirsByUserid(@RequestParam String phone){
        return favoritedirsService.GetDirsByUserid(phone);
    }

    @PostMapping("/DeleteDirsByUserid")
    public boolean DeleteDirsByUserid(String phone,String expert_id){
        return favoritedirsService.DeleteDirsByUserid(phone, expert_id);
    }

    @PostMapping("/CreateDirsByUserid")
    public boolean CreateDirsByUserid(String phone, String expert_id){
        return favoritedirsService.CreateDirsByUserid(phone,expert_id);
    }



}
