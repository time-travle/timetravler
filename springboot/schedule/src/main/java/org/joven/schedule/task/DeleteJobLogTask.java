package org.joven.schedule.task;


import lombok.extern.slf4j.Slf4j;
import org.joven.schedule.init.DefaultExecute;
import org.joven.schedule.mapper.QuartzJobLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = "DeleteJobLogTask")
public class DeleteJobLogTask implements DefaultExecute {
    @Autowired
    private QuartzJobLogMapper quartzJobLogMapper;

    @Override
    public void run(String jsonParams) {
        log.debug("DeleteJobLogTaskDeleteJobLogTaskDeleteJobLogTaskDeleteJobLogTask");
        // 干掉20天之前的日志
        quartzJobLogMapper.deleteLongAgo(20);
    }
}
