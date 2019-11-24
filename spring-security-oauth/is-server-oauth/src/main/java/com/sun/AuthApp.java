package com.sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证服务
 * @author wilson
 *
 */
@SpringBootApplication
public class AuthApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(AuthApp.class, args);
    }
   
}
