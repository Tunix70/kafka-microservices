package com.tunix.kafkadatagenerator.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.tunix.kafkadatagenerator.model.MeasurementType
import java.time.LocalDateTime

data class DataDto(
    val sensorId: Long,
    @JsonFormat(pattern = "yyy-MM-dd'T'HH:mm:ss")
    val timestamp: LocalDateTime,
    val measurement: Double,
    val measurementType: MeasurementType
)