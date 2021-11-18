package com.elec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动通用主程序
 * @author wjl
 */
@MapperScan("com.elec.dal.mapper")
@SpringBootApplication()
    public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
