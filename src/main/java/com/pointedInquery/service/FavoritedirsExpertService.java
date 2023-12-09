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

    List<FavoritedirsExpert> GetDirsByUserid(Object customer_id);

    boolean DeleteDirsByUserid(Object customer_id, Object expert_id);

    boolean CreateDirsByUserid(Object customer_id, Object expert_id);
}
