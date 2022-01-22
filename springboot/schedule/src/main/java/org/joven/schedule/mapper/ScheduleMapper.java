/**
 * Project Name: blog project
 * File Name: ScheduleBaseMapper
 * Package Name: org.joven.schedule.mapper
 * Date: 2020/1/31 20:59
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.schedule.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.joven.schedule.entity.ScheduleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CreateBy Notebook
 * Date: 2020/1/31 20:59
 * Version:
 * Remark:
 */
@Mapper
public interface ScheduleMapper extends BaseMapper<ScheduleEntity> {
    List<ScheduleEntity> getScheduleAllJobs();
}
