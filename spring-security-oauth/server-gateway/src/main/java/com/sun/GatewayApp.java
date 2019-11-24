package com.sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
/**
 * 
 * @author wilson
 *
 */
@EnableZuulProxy
@SpringBootApplication
@EnableResourceServer
public class GatewayApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(GatewayApp.class, args);
    }
}
