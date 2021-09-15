package com.ebiz.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ebiz.user.dao")
public class ProjectUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectUserApplication.class, args);
    }

}
