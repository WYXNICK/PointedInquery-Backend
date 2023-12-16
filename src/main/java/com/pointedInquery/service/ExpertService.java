package com.pointedInquery.service;

import com.pointedInquery.dto.AddExpertDto;
import com.pointedInquery.dto.ExpertDetailedDto;
import com.pointedInquery.entity.Expert;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pointedInquery.service.impl.ExpertServiceImpl;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface ExpertService extends IService<Expert> {
    public ExpertDetailedDto getOneExpert(String phone);
    public List<ExpertServiceImpl.ExpertWithTopics> listByType(int type);
    public List<Expert> listCollectDir(String userID);
    public List<ExpertServiceImpl.ExpertWithTopics> getExpertsWithTopics(String searchString);
    Integer addExpert(AddExpertDto addExpertDto);

    int saveOrUpdate(AddExpertDto addExpertDto);

}
