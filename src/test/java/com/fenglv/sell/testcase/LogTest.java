package com.fenglv.sell.testcase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    public static Logger log = LoggerFactory.getLogger(LogTest.class);
    @Test
    public void testLog(){
        System.out.println("开始测试");
        log.debug("小明{}不想上班","明天");
        log.info("测试 {} 日志","info");
        log.warn("测试 {} 日志","warn");
        log.error("测试 {} 日志","error");

    }
}
