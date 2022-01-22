package org.joven.base.convert;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class ThreadNumConverter extends ClassicConverter {
    /**
     * 当需要显示线程ID的时候，返回当前调用线程的ID
     */
    @Override
    public String convert(ILoggingEvent event) {
        return String.valueOf(Thread.currentThread().getId());
    }
}