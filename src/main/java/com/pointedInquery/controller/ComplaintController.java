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
     创建投诉
    */
    @PostMapping("/CreateComplaint")
    public int CreateComplaint(ComplaintCreateDto complaintCreateDto) {
        return complaintService.CreateComplaint(complaintCreateDto.getOrderId(),complaintCreateDto.getUserId(),complaintCreateDto.getBeUserId(),complaintCreateDto.getContents());
    }

}
