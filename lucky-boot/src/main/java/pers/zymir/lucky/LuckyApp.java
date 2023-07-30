package pers.zymir.lucky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.zymir.lucky.dao")
public class LuckyApp {
    public static void main(String[] args) {
        SpringApplication.run(LuckyApp.class, args);
    }
}
