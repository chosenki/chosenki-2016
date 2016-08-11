package com.ki.service.impl.test;

import com.ki.service.KiTestService;
import org.springframework.stereotype.Service;

@Service("kiTestService")
public class KiTestServiceImpl implements KiTestService {


    public String printHello(String name) {
        String result = "Hello "+ name;
        System.out.println(result);
        return result;
    }
}
