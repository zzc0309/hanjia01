package com.zzc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.zzc"},exclude= SecurityAutoConfiguration.class)
@MapperScan(basePackages = "com.zzc.*")
public class Hanjia01Application {
    public static void main(String[] args) {
        SpringApplication.run(Hanjia01Application.class,args);
    }
}
