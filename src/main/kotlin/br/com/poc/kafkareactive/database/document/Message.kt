package br.com.poc.kafkareactive.database.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Message(
    @Id val key: String,
    val value: String
)