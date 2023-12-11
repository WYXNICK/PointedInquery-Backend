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

    int ChangeStatusComplaintToPass(String order_id, String user_id, String be_user_id);

    int ChangeStatusComplaintToBack(String order_id, String usStringer_id, String be_user_id);
}
