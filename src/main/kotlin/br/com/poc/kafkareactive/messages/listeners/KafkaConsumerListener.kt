package br.com.poc.kafkareactive.messages.listeners

import br.com.poc.kafkareactive.database.document.Message
import br.com.poc.kafkareactive.services.MessageProcessingService
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class KafkaConsumerListener(
    private val messageProcessingService: MessageProcessingService
) {
    @KafkaListener(topics = ["\${app.kafka.input-topic}"], groupId = "\${spring.kafka.consumer.group-id}")
    fun consume(record: ConsumerRecord<String, String>) {

        val message = Message(key = record.key(), value = record.value())
        messageProcessingService.processMessage(message)
            .subscribe(
                { println("Mensagem processada com sucesso: ${message.key}") },
                { error -> println("Erro ao processar mensagem: ${error.message}") }
            )
    }
}
