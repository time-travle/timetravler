/**
 * Project Name: blog project
 * File Name: SequenceController
 * Package Name: org.joven.common.controller
 * Date: 2020/1/5 2:21
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.controller;

import org.joven.common.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 2:21
 * Version: 1.0
 * Remark: 获取对应的序列服务
 */
@RestController
@RequestMapping(value = "/common/seq")
public class SequenceController {
    /*
    使用构造器注入（常量注入不提倡）必须依赖（主要）
     */
    private SequenceService sequenceService;

    @Autowired
    public SequenceController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    @RequestMapping(value = "/currentVal", method = RequestMethod.POST)
    public String getCurrentSeqVal(String seqName) {
        return sequenceService.getCurrentSeqVal(seqName);
    }

    @RequestMapping(value = "/nextVal", method = RequestMethod.POST)
    public String getSeqNextVal(String seqName) {
        return sequenceService.getSeqNextVal(seqName);
    }

    @RequestMapping(value = "/batchVal", method = RequestMethod.POST)
    public List<String> getBatchSeqVal(String seqName, int num) {
        return sequenceService.getBatchSeqVal(seqName, num);
    }
}
