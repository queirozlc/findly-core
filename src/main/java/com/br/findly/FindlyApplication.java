package com.br.findly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

@EnableTransactionManagement(proxyTargetClass = true)
public class FindlyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindlyApplication.class, args);
    }

}
