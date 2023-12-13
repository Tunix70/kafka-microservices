package com.tunix.kafkadatagenerator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaDataGeneratorApplication

fun main(args: Array<String>) {
    runApplication<KafkaDataGeneratorApplication>(*args)
}
