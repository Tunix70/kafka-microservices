package com.tunix.kafkadatagenerator.service

import com.tunix.kafkadatagenerator.model.Data

fun interface KafkaDataService {
    fun send(data: Data)
}