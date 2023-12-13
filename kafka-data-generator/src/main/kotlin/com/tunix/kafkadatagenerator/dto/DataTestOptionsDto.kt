package com.tunix.kafkadatagenerator.dto

import com.tunix.kafkadatagenerator.model.MeasurementType

data class DataTestOptionsDto(
    val delayInSeconds: Int? = null,
    val measurementType: List<MeasurementType>? = emptyList()
)