package com.tunix.kafkadataconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaDataConsumerApplication

fun main(args: Array<String>) {
	runApplication<KafkaDataConsumerApplication>(*args)
}
