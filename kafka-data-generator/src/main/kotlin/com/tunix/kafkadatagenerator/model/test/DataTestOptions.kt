package com.tunix.kafkadatagenerator.model.test

import com.tunix.kafkadatagenerator.model.MeasurementType

data class DataTestOptions (
    val delayInSeconds: Int,
    val measurementType: List<MeasurementType>
)