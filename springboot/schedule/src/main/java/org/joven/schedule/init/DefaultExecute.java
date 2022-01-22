package org.joven.schedule.init;

/**
 * 通过beanName启动的定时任务都要实现该接口
 */
public interface DefaultExecute {
    void run(String jsonParams);
}
