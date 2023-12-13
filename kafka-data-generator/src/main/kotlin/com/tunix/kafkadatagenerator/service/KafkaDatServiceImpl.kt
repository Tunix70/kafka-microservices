package com.tunix.kafkadatagenerator.service

import com.tunix.kafkadatagenerator.model.Data
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kafka.sender.KafkaSender
import reactor.kafka.sender.SenderRecord

@Service
class KafkaDatServiceImpl(
    private val sender: KafkaSender<String, Any>
) : KafkaDataService {
    override fun send(data: Data) {
        sender.send(
            Mono.just(
                SenderRecord.create(
                    data.measurementType.title,
                    0,
                    System.currentTimeMillis(),
                    data.hashCode().toString(),
                    data,
                    null
                )
            )
        )
            .subscribe()
    }
}