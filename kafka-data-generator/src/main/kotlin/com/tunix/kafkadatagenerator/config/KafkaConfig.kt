package com.tunix.kafkadatagenerator.config

import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.config.TopicConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.support.serializer.JsonSerializer
import reactor.kafka.sender.KafkaSender
import reactor.kafka.sender.SenderOptions
import java.time.Duration


@Configuration
class KafkaConfig {
    @Value("\${spring.kafka.bootstrap-servers}")
    private val servers: String? = null

    @Bean
    fun temperatureTopic(): NewTopic {
        return TopicBuilder.name("data-temperature")
            .partitions(5)
            .replicas(1)
            .config(
                TopicConfig.RETENTION_MS_CONFIG,
                Duration.ofDays(7).toMillis().toString()
            )
            .build()
    }

    @Bean
    fun voltageTopic(): NewTopic {
        return TopicBuilder.name("data-voltage")
            .partitions(5)
            .replicas(1)
            .config(
                TopicConfig.RETENTION_MS_CONFIG,
                Duration.ofDays(7).toMillis().toString()
            )
            .build()
    }

    @Bean
    fun powerTopic(): NewTopic {
        return TopicBuilder.name("data-power")
            .partitions(5)
            .replicas(1)
            .config(
                TopicConfig.RETENTION_MS_CONFIG, Duration.ofDays(7).toMillis().toString()
            )
            .build()
    }

    @Bean
    fun senderOptions(): SenderOptions<String, Any> {
        val props: MutableMap<String, Any> = HashMap(3)
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = servers!!
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
        return SenderOptions.create(props)
    }

    @Bean
    fun sender(senderOptions: SenderOptions<String, Any>): KafkaSender<String, Any> {
        return KafkaSender.create(senderOptions)
    }
}