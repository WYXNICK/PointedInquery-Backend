package com.pointedInquery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pointedInquery.entity.Complaint;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface ComplaintService extends IService<Complaint> {



    int CreateComplaint(Object order_id, Object user_id, Object be_user_id,Object contents);

    int ChangeStatusComplaintToPass(Object order_id, Object user_id, Object be_user_id);

    int ChangeStatusComplaintToBack(Object order_id, Object user_id, Object be_user_id);
}
