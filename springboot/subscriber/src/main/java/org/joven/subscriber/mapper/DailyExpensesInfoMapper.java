package org.joven.subscriber.mapper;

import org.joven.subscriber.entity.DailyExpensesInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  对应表为subs_user下的 inf_daily_expenses
 */
@Repository
public interface DailyExpensesInfoMapper {

    List<DailyExpensesInfoEntity> getAllInfos(int beginNum, int pageSizeNum);

    DailyExpensesInfoEntity getInfoById(String id);

    List<DailyExpensesInfoEntity> getInfoByIds(List<String> ids);

    void modifyInfoById(DailyExpensesInfoEntity dailyExpensesInfo);

    void bathModifyInfoById(List<DailyExpensesInfoEntity> lists);

    void bathInsertInfos(List<DailyExpensesInfoEntity> lists);

    void deleteInfoByIds(List<String> ids);
}