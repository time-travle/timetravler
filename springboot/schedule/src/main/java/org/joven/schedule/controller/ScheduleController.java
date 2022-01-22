/**
 * Project Name: blog project
 * File Name: ScheduleController
 * Package Name: org.joven.schedule.controller
 * Date: 2020/1/31 20:59
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.schedule.controller;

import org.joven.schedule.entity.ScheduleEntity;
import org.joven.schedule.utils.QuartzUtils;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * CreateBy Notebook
 * Date: 2020/1/31 20:59
 * Version:
 * Remark:
 */
@Controller
@RequestMapping("/quartz/")
public class ScheduleController {
    //注入任务调度
    @Autowired
    private Scheduler scheduler;

    @RequestMapping("/createJob")
    @ResponseBody
    public String createJob(ScheduleEntity quartzBean) {
        try {
            //进行测试所以写死
            quartzBean.setClassName("com.hjljy.blog.Quartz.MyTask1");
            quartzBean.setJobName("test1");
            quartzBean.setCron("*/10 * * * * ?");
            QuartzUtils.createScheduleJob(scheduler, quartzBean);
        } catch (Exception e) {
            return "创建失败";
        }
        return "创建成功";
    }

    @RequestMapping("/pauseJob")
    @ResponseBody
    public String pauseJob() {
        try {
            QuartzUtils.pauseScheduleJob(scheduler, "test1");
        } catch (Exception e) {
            return "暂停失败";
        }
        return "暂停成功";
    }

    @RequestMapping("/runOnce")
    @ResponseBody
    public String runOnce() {
        try {
            QuartzUtils.runOnce(scheduler, "test1");
        } catch (Exception e) {
            return "运行一次失败";
        }
        return "运行一次成功";
    }

    @RequestMapping("/resume")
    @ResponseBody
    public String resume() {
        try {

            QuartzUtils.resumeScheduleJob(scheduler, "test1");
        } catch (Exception e) {
            return "启动失败";
        }
        return "启动成功";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(ScheduleEntity quartzBean) {
        try {
            //进行测试所以写死
            quartzBean.setClassName("com.hjljy.blog.Quartz.MyTask1");
            quartzBean.setJobName("test1");
            quartzBean.setCron("10 * * * * ?");
            QuartzUtils.updateScheduleJob(scheduler, quartzBean);
        } catch (Exception e) {
            return "启动失败";
        }
        return "启动成功";
    }
}
