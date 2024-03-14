package com.aixtor.employee.spring.mvc.controller;


import com.aixtor.employee.service.EmployeeLocalService;
import com.aixtor.employee.service.EmployeeLocalServiceUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
    @ComponentScan("com.aixtor.employee.spring.mvc.controller")
    public class EmployeeConfig {
        // Define Spring beans for Liferay services
//        @Bean
//        public EmployeeLocalService myEntityLocalService() {
//            return EmployeeLocalServiceUtil.getService();
//        }
    }

