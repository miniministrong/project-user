package com.ebiz.user;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@SpringBootTest
class ProjectUserApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("========================");
        System.out.println(new Date());
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        System.out.println(LocalDateTime.now());
        System.out.println("========================");
    }

}
