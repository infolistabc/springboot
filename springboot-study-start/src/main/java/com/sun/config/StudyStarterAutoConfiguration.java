package com.sun.config;

import com.sun.other.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 存放我们的配置类，用来配置我们自定义的bean的。既然是一个配置类，那么我们就需要有@Configuration进行声明
 * 
 * @Author jiawei huang
 * @Since 2019年8月23日
 * @Version 1.0
 */
@Configuration
// 导入我们自定义的配置类,供当前类使用
@EnableConfigurationProperties(StudentConfigProperties.class)
// 当存在某个类时，此自动配置类才会生效,这里可以使用外部的String类名
@ConditionalOnClass(Student.class)
// 只有web应用程序时此自动配置类才会生效
@ConditionalOnWebApplication
public class StudyStarterAutoConfiguration {
    /**
     * 当存在study.config.enable=true的配置时,这个Student bean才生效
     * 
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "study.config", name = "enable", havingValue = "true")
    public Student defaultStudent(StudentConfigProperties studyConfigProperties) {
    	Student student = new Student();
    	student.setAge(studyConfigProperties.getAge());
    	student.setName(studyConfigProperties.getName());
    	return student;
    }
}
