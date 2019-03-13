package com.example.springboot;

import com.example.springboot.handler.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建定时任务
 */
@Component
public class ScheduledTasks {
    private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * @Scheduled(fixedRate = 5000) 注解来定义每过5秒执行的任务
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * @Scheduled(cron="*\/5*****") ：通过cron表达式定义规则
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        LOGGER.info("现在时间：" + dateFormat.format(new Date()));
    }

}
