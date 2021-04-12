package com.sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author wilson
 */
@SpringBootApplication
public class GrpcClientApp {
	
	public static void main(String[] args) {
	    SpringApplication.run(GrpcClientApp.class, args);
	}
	
	
}