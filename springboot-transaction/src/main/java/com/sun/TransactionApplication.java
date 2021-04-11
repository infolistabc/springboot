package com.sun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wilson
 */
@SpringBootApplication
@MapperScan("com.sun.dao")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TransactionApplication {
    public static void main( String[] args ){
        SpringApplication.run(TransactionApplication.class, args);
    }
}
