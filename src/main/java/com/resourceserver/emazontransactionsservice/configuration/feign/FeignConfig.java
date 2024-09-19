package com.resourceserver.emazontransactionsservice.configuration.feign;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new CustomErrorDecoder();
    }
}
