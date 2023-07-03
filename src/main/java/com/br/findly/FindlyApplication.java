package com.br.findly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

@EnableTransactionManagement(proxyTargetClass = true)
@EnableAsync
public class FindlyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindlyApplication.class, args);
    }

}
