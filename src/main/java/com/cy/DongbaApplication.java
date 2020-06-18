package com.cy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.cy.pj.sys.dao")
@SpringBootApplication
public class DongbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DongbaApplication.class, args);
    }

}
