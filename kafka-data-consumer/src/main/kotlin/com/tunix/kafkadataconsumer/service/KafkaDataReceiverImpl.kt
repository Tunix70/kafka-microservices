package com.tunix.kafkadataconsumer.service

import com.google.gson.GsonBuilder
import com.tunix.kafkadataconsumer.config.LocalDateTimeDeserializer
import com.tunix.kafkadataconsumer.model.Data
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import reactor.kafka.receiver.KafkaReceiver
import reactor.kafka.receiver.ReceiverRecord
import java.time.LocalDateTime

@Service
class KafkaDataReceiverImpl(
    private val receiver: KafkaReceiver<String, Any>,
    private val localDateTimeDeserializer: LocalDateTimeDeserializer,
    private val kafkaDataService: KafkaDataService
) : KafkaDataReceiver {

    @PostConstruct
    private fun init() {
        fetch()
    }

    override fun fetch() {
        val gson = GsonBuilder()
            .registerTypeAdapter(LocalDateTime::class.java, localDateTimeDeserializer)
            .create()
        receiver.receive()
            .subscribe { r: ReceiverRecord<String?, Any> ->
                val data: Data = gson
                    .fromJson(r.value().toString(), Data::class.java)
                kafkaDataService.handle(data)
                r.receiverOffset().acknowledge()
            }
    }

}