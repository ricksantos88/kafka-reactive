package br.com.poc.kafkareactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkareactiveApplication

fun main(args: Array<String>) {
	runApplication<KafkareactiveApplication>(*args)
}
