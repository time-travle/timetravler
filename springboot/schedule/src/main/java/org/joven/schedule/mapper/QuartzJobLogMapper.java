package org.joven.schedule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.joven.schedule.entity.QuartzJobLogEntity;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface QuartzJobLogMapper extends BaseMapper<QuartzJobLogEntity> {
    void deleteLongAgo(int days);
}
