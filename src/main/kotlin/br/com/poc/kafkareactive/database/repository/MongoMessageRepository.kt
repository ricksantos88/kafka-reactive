package br.com.poc.kafkareactive.database.repository

import br.com.poc.kafkareactive.database.document.Message
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoMessageRepository : ReactiveMongoRepository<Message, String>