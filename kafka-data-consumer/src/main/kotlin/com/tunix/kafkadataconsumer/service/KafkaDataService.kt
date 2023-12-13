package com.tunix.kafkadataconsumer.service

import com.tunix.kafkadataconsumer.model.Data

fun interface KafkaDataService {
    fun handle(data: Data)
}