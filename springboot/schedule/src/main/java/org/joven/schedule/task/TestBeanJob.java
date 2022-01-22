package org.joven.schedule.task;

import lombok.extern.slf4j.Slf4j;
import org.joven.schedule.init.DefaultExecute;
import org.springframework.stereotype.Component;

@Component(value = "TestBeanJob")
@Slf4j
public class TestBeanJob implements DefaultExecute {

    @Override
    public void run(String params) {
        log.debug("TestBeanJob 执行  参数{}", params);
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
