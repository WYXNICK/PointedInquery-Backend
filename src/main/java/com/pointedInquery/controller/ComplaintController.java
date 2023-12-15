package com.pointedInquery.controller;


import com.pointedInquery.dto.ComplaintCreateDto;
import com.pointedInquery.entity.Complaint;
import com.pointedInquery.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    /*
    管理员可以得到所有的投诉
    */
//    @PostMapping("/GetComplaint")
//    public List<Complaint> GetComplaint() {
//        return complaintService.list();
//    }


    /*
     创建投诉
    */
    @PostMapping("/CreateComplaint")
    public int CreateComplaint(ComplaintCreateDto complaintCreateDto) {
        return complaintService.CreateComplaint(complaintCreateDto.getOrderId(),complaintCreateDto.getUserId(),complaintCreateDto.getBeUserId(),complaintCreateDto.getContents());
    }

    /*
    管理员可以更改投诉的状态,待定
    */
//    @PostMapping("/ChangeStatusComplaintToPass")
//    public int ChangeStatusComplaintToPass(@RequestParam String orderId, @RequestParam String userId, @RequestParam String beUserId){
//        return complaintService.ChangeStatusComplaintToPass(orderId, userId, beUserId);
//    }

//    @PostMapping("/ChangeStatusComplaintToBack")
//    public int ChangeStatusComplaintToBack(@RequestParam String orderId, @RequestParam String userId, @RequestParam String beUserId){
//        return complaintService.ChangeStatusComplaintToBack(orderId, userId, beUserId);
//    }







}
