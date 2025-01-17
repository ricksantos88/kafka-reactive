package br.com.poc.kafkareactive.messages.producers

import br.com.poc.kafkareactive.database.model.ProcessedMessage
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun publishProcessedMessage(processedMessage: ProcessedMessage): Mono<Void> {
        return Mono.create<Void> { sink ->
            kafkaTemplate.send(
                "\${app.kafka.processed-topic}",
                processedMessage.key,
                processedMessage.value
            ).whenComplete { _: SendResult<String, String>?, exception: Throwable? ->
                if (exception != null) {
                    sink.error(exception)
                } else {
                    println("Mensagem publicada com sucesso: ${processedMessage.key}")
                    sink.success()
                }
            }
        }
    }

}