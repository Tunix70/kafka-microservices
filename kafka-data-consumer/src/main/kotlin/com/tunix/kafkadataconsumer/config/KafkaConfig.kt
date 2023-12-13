package com.tunix.kafkadataconsumer.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.kafka.receiver.KafkaReceiver
import reactor.kafka.receiver.ReceiverOptions
import reactor.kafka.receiver.ReceiverPartition

@Configuration
class KafkaConfig {
    @Value("\${spring.kafka.bootstrap-servers}")
    private val servers: String? = null

    @Value("\${topics}")
    private val topics: List<String>? = null

    @Bean
    fun receiverProperties(): MutableMap<String, Any> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = (servers)!!
        props[ConsumerConfig.GROUP_ID_CONFIG] = "1"
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        return props
    }

    @Bean
    fun receiverOptions(): ReceiverOptions<String, Any> {
        val receiverOptions = ReceiverOptions
            .create<String, Any>(receiverProperties())
        return receiverOptions.subscription(topics)
            .addAssignListener { partitions: Collection<ReceiverPartition?> ->
                println("onPartitionAssigned: $partitions")
            }
            .addRevokeListener { partitions: Collection<ReceiverPartition?> ->
                println("onPartitionRevoked: $partitions")
            }
    }

    @Bean
    fun receiver(receiverOptions: ReceiverOptions<String, Any>):
            KafkaReceiver<String, Any> {
        return KafkaReceiver.create(receiverOptions)
    }
}