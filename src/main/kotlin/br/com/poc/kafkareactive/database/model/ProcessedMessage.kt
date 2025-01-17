package br.com.poc.kafkareactive.database.model

data class ProcessedMessage(
    val key: String,
    val value: String,
    val processedAt: Long
)