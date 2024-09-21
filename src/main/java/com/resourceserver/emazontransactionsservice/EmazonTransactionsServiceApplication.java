package com.resourceserver.emazontransactionsservice;

import com.resourceserver.emazontransactionsservice.configuration.security.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(RsaKeyProperties.class)
public class EmazonTransactionsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmazonTransactionsServiceApplication.class, args);
    }

}
