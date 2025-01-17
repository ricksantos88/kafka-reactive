package br.com.poc.kafkareactive.configs

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaConfig {

    @Value("\${app.kafka.input-topic}")
    private lateinit var inputTopicName: String

    @Value("\${app.kafka.processed-topic}")
    private lateinit var processedTopicName: String

    @Bean
    fun inputTopic(): NewTopic = NewTopic(inputTopicName, 3, 1)

    @Bean
    fun processedTopic(): NewTopic = NewTopic(processedTopicName, 3, 1)
}