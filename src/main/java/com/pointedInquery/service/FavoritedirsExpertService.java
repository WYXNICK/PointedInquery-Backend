package com.pointedInquery.service;

import com.pointedInquery.entity.FavoritedirsExpert;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 */
public interface FavoritedirsExpertService extends IService<FavoritedirsExpert> {

    List<FavoritedirsExpert> GetDirsByUserid(String customer_id);

    boolean DeleteDirsByUserid(String phone, String expert_id);

    boolean CreateDirsByUserid(String customer_id, String expert_id);
}
