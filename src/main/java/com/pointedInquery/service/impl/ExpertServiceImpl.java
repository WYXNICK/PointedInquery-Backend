package com.pointedInquery.service.impl;

import com.pointedInquery.entity.Expert;
import com.pointedInquery.mapper.ExpertMapper;
import com.pointedInquery.service.ExpertService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class ExpertServiceImpl extends ServiceImpl<ExpertMapper, Expert> implements ExpertService {

}
