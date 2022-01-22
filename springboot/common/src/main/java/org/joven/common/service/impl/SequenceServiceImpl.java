/**
 * Project Name: blog project
 * File Name: SequenceServiceImpl
 * Package Name: org.joven.common.service.impl
 * Date: 2020/1/5 17:26
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.joven.common.mapper.SequenceMapper;
import org.joven.common.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 17:26
 * Version: 1.0
 * Remark: 序列实现类
 */
@Slf4j
@Service("SequenceService")
public class SequenceServiceImpl implements SequenceService {
    /*
    必须的使用构造器注入（变量注入不提倡）必须依赖（主要）
     */
    private SequenceMapper sequenceMapper;

    @Autowired
    public SequenceServiceImpl(SequenceMapper sequenceMapper) {
        this.sequenceMapper = sequenceMapper;
    }


    @Override
    public String getCurrentSeqVal(String seqName) {
        String resp = sequenceMapper.getCurrentSeqVal(seqName);
        log.debug("resp ={}", resp);
        return resp;
    }

    @Override
    public String getSeqNextVal(String seqName) {
        String resp = sequenceMapper.getSeqNextVal(seqName);
        log.debug("resp = {}", resp);
        return resp;
    }

    @Override
    public List<String> getBatchSeqVal(String seqName, int num) {
        List<String> resp = sequenceMapper.getBatchSeqVal(seqName, num);
        log.debug("resp = {}", resp);
        return resp;
    }
}
