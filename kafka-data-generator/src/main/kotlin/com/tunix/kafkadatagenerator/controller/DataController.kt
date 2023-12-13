package com.tunix.kafkadatagenerator.controller

import com.tunix.kafkadatagenerator.dto.DataDto
import com.tunix.kafkadatagenerator.dto.DataTestOptionsDto
import com.tunix.kafkadatagenerator.mapper.DataMapper
import com.tunix.kafkadatagenerator.mapper.DataTestOptionsMapper
import com.tunix.kafkadatagenerator.service.KafkaDataService
import com.tunix.kafkadatagenerator.service.TestDataService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/data")
class DataController(
    private val kafkaDataService: KafkaDataService,
    private val testDataService: TestDataService,
    private val dataMapper: DataMapper,
    private val dataTestOptionsMapper: DataTestOptionsMapper
) {
    @PostMapping("/send")
    fun send(@RequestBody dataDto: DataDto) {
        val data = dataMapper.toModel(dataDto)
        kafkaDataService.send(data)
    }

    @PostMapping("/test/send")
    fun testSend(@RequestBody testOptionsDto: DataTestOptionsDto) {
        val testOptions = dataTestOptionsMapper.toModel(testOptionsDto)
        testDataService.sendMessage(testOptions)
    }
}