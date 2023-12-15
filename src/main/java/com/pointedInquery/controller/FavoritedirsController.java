package com.pointedInquery.controller;


import com.pointedInquery.dto.ExpertDetailedDto;
import com.pointedInquery.service.FavoritedirsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/favoritedirs-expert")
public class FavoritedirsController {

    @Autowired
    private FavoritedirsService favoritedirsService;

    @PostMapping("/GetDirsByUserid")
    public List<ExpertDetailedDto> GetDirsByUserid(@RequestParam String phone){
        return favoritedirsService.GetDirsByUserid(phone);
    }

    @PostMapping("/DeleteDirsByUserid")
    public boolean DeleteDirsByUserid(@RequestParam String phone,@RequestParam String expertId){
        return favoritedirsService.DeleteDirsByUserid(phone, expertId);
    }

    @PostMapping("/CreateDirsByUserid")
    public boolean CreateDirsByUserid(String phone, String expertId){
        return favoritedirsService.CreateDirsByUserid(phone,expertId);
    }



}
