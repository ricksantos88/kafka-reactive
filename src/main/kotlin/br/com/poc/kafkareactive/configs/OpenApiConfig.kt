package br.com.poc.kafkareactive.configs

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Kafka Reactive POC")
                    .description("Kafka Reactive POC")
                    .version("1.0.0")
            )
    }
}