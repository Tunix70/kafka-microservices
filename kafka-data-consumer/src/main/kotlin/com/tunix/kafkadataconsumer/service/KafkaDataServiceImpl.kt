package com.tunix.kafkadataconsumer.service

import com.tunix.kafkadataconsumer.model.Data
import org.springframework.stereotype.Service

@Service
class KafkaDataServiceImpl: KafkaDataService {
    override fun handle(data: Data) {
        println("Data object is received: {data}$data")
    }
}