package org.joven.subscriber.controller;


import org.joven.base.entity.ResponseBody;
import org.joven.subscriber.entity.DailyExpensesInfoEntity;
import org.joven.subscriber.entity.DailyExpensesInfoResp;
import org.joven.subscriber.service.DailyExpensesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/dailyExpensesInfo")
@RestController
public class DailyExpensesInfoController {

    @Autowired
    DailyExpensesInfoService dailyExpensesInfoService;

    @RequestMapping(value = "/bathModifyInfoById")
    public ResponseBody bathModifyInfoById (List<DailyExpensesInfoEntity> lists){
        return dailyExpensesInfoService.bathModifyInfoById(lists);
    }
    @RequestMapping(value = "/bathInsertInfos")
    public ResponseBody bathInsertInfos(List<DailyExpensesInfoEntity> lists){
        return dailyExpensesInfoService.bathInsertInfos(lists);
    }

    @RequestMapping(value = "/getInfoById/{id}")
    public DailyExpensesInfoEntity getInfoById(@PathVariable String id) {
        return dailyExpensesInfoService.getInfoById(id);
    }

    @RequestMapping(value = "/getAll")
    public DailyExpensesInfoResp getAll(@RequestParam("beginNum") Integer beginNum,
                                        @RequestParam("pageSizeNum") Integer pageSizeNum) {
        return dailyExpensesInfoService.getAllInfos(beginNum, pageSizeNum);
    }

    @RequestMapping(value = "/delete")
    public ResponseBody deleteInfoByIds(List<String> ids) {
        return dailyExpensesInfoService.deleteInfoByIds(ids);
    }

    @RequestMapping(value = "/delete/{id}")
    public ResponseBody deleteInfoByIds(String id) {
        List<String> req = new ArrayList<String>();
        req.add(id);
        return dailyExpensesInfoService.deleteInfoByIds(req);
    }

    @RequestMapping(value = "/modify")
    public ResponseBody modifyInfo(DailyExpensesInfoEntity targetInfo) {

        return dailyExpensesInfoService.modifyInfoById(targetInfo);
    }

    @RequestMapping(value = "/getInfos")
    public DailyExpensesInfoResp getInfoByIds(List<String> ids) {
        return dailyExpensesInfoService.getInfoByIds(ids);
    }
}
