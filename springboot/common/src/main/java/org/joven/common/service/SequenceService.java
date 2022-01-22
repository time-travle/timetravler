/**
 * Project Name: blog project
 * File Name: SequenceService
 * Package Name: org.joven.common.service.impl
 * Date: 2020/1/5 17:18
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.service;

import java.util.List;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 17:18
 * Version: 1.0
 * Remark: 序列实现接口
 */
public interface SequenceService {
    public String getCurrentSeqVal(String seqName);

    public String getSeqNextVal(String seqName);

    public List<String> getBatchSeqVal(String seqName, int num);
}
