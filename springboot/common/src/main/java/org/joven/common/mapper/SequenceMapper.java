/**
 * Project Name: blog project
 * File Name: SequenceMapper
 * Package Name: org.joven.common.mapper
 * Date: 2020/1/5 17:31
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 17:31
 * Version:1.0
 * Remark: 序列查询对接数据接口文件
 */
@Repository
public interface SequenceMapper {
    public String getCurrentSeqVal(@Param("seqName") String seqName);

    public String getSeqNextVal(@Param("seqName") String seqName);

    public List<String> getBatchSeqVal(@Param("seqName") String seqName, @Param("num") int num);
}
