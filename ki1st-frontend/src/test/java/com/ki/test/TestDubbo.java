package com.ki.test;

import com.ki.service.KiTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/8/11.
 */
@ContextConfiguration(locations = "classpath:config/ki-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDubbo {

    @Resource
    private KiTestService kiTestService;

    @Test
    public void testService(){
        System.out.println(kiTestService.printHello("Wangxiang"));
        System.out.println(kiTestService.printHello("Wangpan"));
        System.out.println(kiTestService.printHello("Wangqiongwu"));
    }


}
