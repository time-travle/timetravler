package org.joven.schedule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.joven.schedule.entity.QuartzJobEntity;

@Mapper
public interface QuartzJobMapper extends BaseMapper<QuartzJobEntity> {
}
