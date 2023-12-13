package com.tunix.kafkadatagenerator.service

import com.tunix.kafkadatagenerator.model.test.DataTestOptions

fun interface TestDataService {
    fun sendMessage(testOptions: DataTestOptions)
}