package com.tunix.kafkadatagenerator.util

class NumberUtil {
    companion object {
        @JvmStatic
        fun randomNumber(min: Double, max: Double): Double {
            return (Math.random() * (max - min)) + min
        }
    }
}