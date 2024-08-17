package com.tolunayoezcan.spring_boot_unoptimized;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootUnoptimizedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUnoptimizedApplication.class, args);
    }

}
