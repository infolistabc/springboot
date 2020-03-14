package com.sun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.sun.dao")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class MybatisApplication {
    public static void main( String[] args ){
        SpringApplication.run(MybatisApplication.class, args);
    }
}
