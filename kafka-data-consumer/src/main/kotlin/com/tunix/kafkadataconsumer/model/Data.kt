package com.tunix.kafkadataconsumer.model

import java.time.LocalDateTime

data class Data(
    val sensorId: Long,
    val timestamp: LocalDateTime? = LocalDateTime.now(),
    val measurement: Double,
    val measurementType: MeasurementType
)

enum class MeasurementType(val title: String) {
    TEMPERATURE("data-temperature"),
    VOLTAGE("data-voltage"),
    POWER("data-power");
}