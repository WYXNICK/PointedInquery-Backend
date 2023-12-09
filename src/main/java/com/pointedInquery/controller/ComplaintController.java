package com.pointedInquery.controller;


import com.pointedInquery.entity.Complaint;
import com.pointedInquery.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    /*
    管理员可以得到所有的投诉
    */
    @PostMapping("/GetComplaint")
    public List<Complaint> GetComplaint(@RequestParam Map<String, Object> param) {
        return complaintService.list();
    }


    /*
     创建投诉
    */
    @PostMapping("/CreateComplaint")
    public int CreateComplaint(@RequestParam Map<String, Object> param) {
        return complaintService.CreateComplaint(param.get("Order_id"),param.get("user_id"),param.get("be_user_id"),param.get("contents"));
    }

    /*
    管理员可以更改投诉的状态
    */
    @PostMapping("/ChangeStatusComplaintToPass")
    public int ChangeStatusComplaintToPass(@RequestParam Map<String, Object> param){
        return complaintService.ChangeStatusComplaintToPass(param.get("Order_id"),param.get("user_id"),param.get("be_user_id"));
    }

    @PostMapping("/ChangeStatusComplaintToBack")
    public int ChangeStatusComplaintToBack(@RequestParam Map<String, Object> param){
        return complaintService.ChangeStatusComplaintToBack(param.get("Order_id"),param.get("user_id"),param.get("be_user_id"));
    }







}
