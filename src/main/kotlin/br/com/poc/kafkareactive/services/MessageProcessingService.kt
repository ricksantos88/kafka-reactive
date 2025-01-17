package br.com.poc.kafkareactive.services


import br.com.poc.kafkareactive.database.document.Message
import br.com.poc.kafkareactive.database.model.ProcessedMessage
import br.com.poc.kafkareactive.database.repository.MongoMessageRepository
import br.com.poc.kafkareactive.messages.producers.KafkaProducer
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.Instant

@Service
class MessageProcessingService(
    private val kafkaProducer: KafkaProducer,
    private val mongoMessageRepository: MongoMessageRepository
) {

    fun processMessage(message: Message): Mono<Void> {
        val processedMessage = ProcessedMessage(
            key = message.key,
            value = "Processed: ${message.value}",
            processedAt = Instant.now().toEpochMilli()
        )

        return mongoMessageRepository.save(message) // Salva no banco reativamente
            .then(kafkaProducer.publishProcessedMessage(processedMessage)) // Publica no Kafka
    }
}