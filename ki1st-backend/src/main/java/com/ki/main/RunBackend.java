package com.ki.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/8/6.
 */
public class RunBackend {

    public static void main(String[] args){
        System.setProperty("java.version", "1.8");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/ki-context.xml");
        com.alibaba.dubbo.container.Main.main(args);

    }

}