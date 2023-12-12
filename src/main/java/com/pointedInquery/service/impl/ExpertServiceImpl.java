package com.pointedInquery.service.impl;

import com.pointedInquery.entity.Expert;
import com.pointedInquery.mapper.ExpertMapper;
import com.pointedInquery.service.ExpertService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class ExpertServiceImpl extends ServiceImpl<ExpertMapper, Expert> implements ExpertService {
    @Autowired
    private ExpertMapper expertMapper;

    @Override
    public List<Expert> listByType(int type) {
        return expertMapper.selectByType(type);
    }

    @Override
    public List<Expert> listCollectDir(String userID) {
        return expertMapper.selectCollectExpert(userID);
    }


}
