package com.pointedInquery.controller;


import com.pointedInquery.dto.ComplaintCreateDto;
import com.pointedInquery.entity.Complaint;
import com.pointedInquery.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public int CreateComplaint(ComplaintCreateDto complaintCreateDto) {
        return complaintService.CreateComplaint(complaintCreateDto.getOrderId(),complaintCreateDto.getUserId(),complaintCreateDto.getBeUserId(),complaintCreateDto.getContents());
    }

    /*
    管理员可以更改投诉的状态
    */
    @PostMapping("/ChangeStatusComplaintToPass")
    public int ChangeStatusComplaintToPass(@RequestParam String order_id, @RequestParam String user_id, @RequestParam String be_user_id){
        return complaintService.ChangeStatusComplaintToPass(order_id, user_id, be_user_id);
    }

    @PostMapping("/ChangeStatusComplaintToBack")
    public int ChangeStatusComplaintToBack(@RequestParam String order_id, @RequestParam String user_id, @RequestParam String be_user_id){
        return complaintService.ChangeStatusComplaintToBack(order_id, user_id, be_user_id);
    }







}
