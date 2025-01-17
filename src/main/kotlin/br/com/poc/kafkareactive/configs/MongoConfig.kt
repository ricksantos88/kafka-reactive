package br.com.poc.kafkareactive.configs

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing

@Configuration
@EnableReactiveMongoAuditing
class MongoConfig