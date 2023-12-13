package com.tunix.kafkadatagenerator.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/ping")

class PingController {
    val log: Logger = LoggerFactory.getLogger(PingController::class.java)

    @GetMapping
    fun getStatus(): String {
        log.info("Call ping application")
        return "Application is working.."
    }
}