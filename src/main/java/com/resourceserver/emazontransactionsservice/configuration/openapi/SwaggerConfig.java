package com.resourceserver.emazontransactionsservice.configuration.openapi;

import com.resourceserver.emazontransactionsservice.ports.driving.constants.OpenApiConstants;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title(OpenApiConstants.OPENAPI_TITTLE)
                        .version(OpenApiConstants.OPENAPI_VERSION)
                        .description(OpenApiConstants.OPENAPI_DESCRIPTION)


                );

    }
}