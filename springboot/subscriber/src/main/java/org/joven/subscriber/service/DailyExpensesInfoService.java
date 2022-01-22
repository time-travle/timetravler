package org.joven.subscriber.service;


import org.joven.base.entity.ResponseBody;
import org.joven.subscriber.entity.DailyExpensesInfoEntity;
import org.joven.subscriber.entity.DailyExpensesInfoResp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyExpensesInfoService {

    DailyExpensesInfoResp getAllInfos(Integer begin, Integer pageSize);

    DailyExpensesInfoEntity getInfoById(String id);

    DailyExpensesInfoResp getInfoByIds(List<String> ids);

    ResponseBody modifyInfoById(DailyExpensesInfoEntity targetInfo);

    ResponseBody deleteInfoByIds(List<String> ids);

    ResponseBody bathModifyInfoById (List<DailyExpensesInfoEntity> lists);

    ResponseBody bathInsertInfos(List<DailyExpensesInfoEntity> lists);
}
