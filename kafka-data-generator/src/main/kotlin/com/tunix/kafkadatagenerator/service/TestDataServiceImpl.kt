package com.tunix.kafkadatagenerator.service

import com.tunix.kafkadatagenerator.model.Data
import com.tunix.kafkadatagenerator.model.test.DataTestOptions
import com.tunix.kafkadatagenerator.util.NumberUtil
import org.springframework.stereotype.Service
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit


@Service
class TestDataServiceImpl(
    private val kafkaDataService: KafkaDataService
) : TestDataService {
    private val executorService: ScheduledExecutorService =
        Executors.newSingleThreadScheduledExecutor()

    override fun sendMessage(testOptions: DataTestOptions) {
        if (testOptions.measurementType.isNotEmpty()) {
            executorService.scheduleAtFixedRate(
                {
                    val data = createSentData(testOptions)
                    kafkaDataService.send(data)
                },
                0,
                testOptions.delayInSeconds.toLong(),
                TimeUnit.SECONDS
            )
        }
    }

    fun createSentData(testOptions: DataTestOptions): Data {
        return Data(
            NumberUtil.randomNumber(1.0, 10.0).toLong(),
            null,
            NumberUtil.randomNumber(15.0, 20.0),
            testOptions.measurementType.random()
        )
    }
}