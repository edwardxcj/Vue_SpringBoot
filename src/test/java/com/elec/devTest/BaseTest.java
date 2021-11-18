package com.elec.devTest;

import com.elec.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wangjinglin
 * @date 2020-06-28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class BaseTest {

    @Test
    public void run(){
        System.out.println("单元测试基础父类");
    }
}
