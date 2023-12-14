package com.pointedInquery.service;

import com.pointedInquery.dto.ExpertDetailedDto;
import com.pointedInquery.entity.Favoritedirs;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface FavoritedirsService extends IService<Favoritedirs> {
    public List<ExpertDetailedDto> GetDirsByUserid(String phone);
    public boolean DeleteDirsByUserid(String phone, String expert_id);
    public boolean CreateDirsByUserid(String phone, String expert_id);

}
